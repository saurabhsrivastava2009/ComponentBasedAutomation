# ComponentBasedAutomation
Component based framework for Automation

How to use?
+ Add this dependency in your pom.xml

```xml
    <dependency>
    <groupId>org.penzoi</groupId>
    <artifactId>componentbasedautomation</artifactId>
    <version>1.2-SNAPSHOT</version>
    </dependency>
```
+ Update your settings.xml file <i>~/.m2/settings.xml<i>

```xml
    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
    http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>github</id>
            <repositories>
                <repository>
                    <id>central</id>
                    <url>https://repo1.maven.org/maven2</url>
                </repository>
                <repository>
                    <id>github</id>
                    <url>https://maven.pkg.github.com/saurabhsrivastava2009/ComponentBasedAutomation</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>

    <servers>
        <server>
            <id>github</id>
            <username>USERNAME</username>
            <password>TOKEN</password>
        </server>
    </servers>
    </settings>
```
Example Code:
```java
    private Input searchBox = new Input(By.cssSelector("[id=\"search_form_input_homepage\"]"));
    private Button searchButton = new Button(By.cssSelector("[id=\"search_button_homepage\"]"));
    private Text searchWidgetText = new Text(By.cssSelector(".js-about-item-title"));

    @Test
    public void openDuckDuckGo() {
        navigateToPage("https://www.duckduckgo.com/",searchBox);
        verify(searchBox.isVisible(), true, "Search bar is available");
        verify(searchButton.isVisible(), true, "search button is available");
        searchBox.enterText("hello world java");
        searchButton.click(searchWidgetText);
        verify(searchWidgetText.getText().equalsIgnoreCase("hello world"),true,"code widget is visible");
    }
```
