package com.componentBasedAutomation.Utilities;/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonFrameworkLogger {
    private static Logger LOGGER;

    public CommonFrameworkLogger(Class clazz){
        LOGGER = Logger.getLogger(clazz);
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public Logger getLOGGER(){
        return LOGGER;
    }
}
