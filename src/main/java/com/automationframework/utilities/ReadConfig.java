package com.automationframework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    String path =  System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
    public ReadConfig() throws FileNotFoundException,IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
    }

    public String getKey(String key){
        String value = properties.getProperty(key);
        if(value!=null){
            return value;
        }
        else {
            throw new RuntimeException("Value for the key not found");
            }
        }

    }

