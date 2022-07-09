package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

import java.util.List;

public class Select extends BaseComponent {

    public Select(By selectBy) {
        this.mainLocator = selectBy;
    }

    public void performOperationByText(String text, OperationType operationType) {
        if (operationType.getOperationType().equalsIgnoreCase("select")) {
            Element.selectByText(this.mainLocator, text);
        } else {
            Element.deSelectByText(this.mainLocator, text);
        }

    }

    public void performOperationByValue(String value, OperationType operationType) {
        if (operationType.getOperationType().equalsIgnoreCase("select")) {
            Element.selectByValue(this.mainLocator, value);
        } else {
            Element.deSelectByValue(this.mainLocator, value);
        }
    }

    public void performOperationByIndex(int index, OperationType operationType) {
        if (operationType.getOperationType().equalsIgnoreCase("select")) {
            Element.selectByIndex(this.mainLocator, index);
        } else {
            Element.deSelectByIndex(this.mainLocator, index);
        }
    }

    public void selectMultipleByText(List<String> listOfText) {
        if (Element.isMultipleSelectAvailable(this.mainLocator)) {
            listOfText.stream().forEach(text -> performOperationByText(text, OperationType.SELECT));
        }
    }

    public void selectMultipleByValue(List<String> listOfValues) {
        if (Element.isMultipleSelectAvailable(this.mainLocator)) {
            listOfValues.stream().forEach(value -> performOperationByValue(value, OperationType.SELECT));
        }
    }

    public void selectMultipleByIndex(List<Integer> listOfIndex) {
        if (Element.isMultipleSelectAvailable(this.mainLocator)) {
            listOfIndex.stream().forEach(index -> performOperationByIndex(index, OperationType.SELECT));
        }
    }

    public void deSelectAll() {
        Element.deSelectAll(this.mainLocator);
    }

    public static enum OperationType {
        SELECT("select"),
        DESELECT("deselect");

        private final String operationType;

        OperationType(String operationType) {
            this.operationType = operationType;
        }

        public String getOperationType() {
            return operationType;
        }
    }
}
