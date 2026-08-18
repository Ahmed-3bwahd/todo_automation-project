package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String getEnvironment = System.getProperty("prod","PROD");

        switch (getEnvironment){
            case "PROD":
              properties = PropertiesUtils.readFile("src/test/java/com/qacart/todo/config/production.properties");
              break;
            case "LOCAL":
              properties = PropertiesUtils.readFile("src/test/java/com/qacart/todo/config/local.properties");
              break;
            default:
                throw new RuntimeException("this environment is not found");
        }
    }

    public static ConfigUtils getInstance(){
        if(configUtils == null){
            configUtils = new ConfigUtils();
        }
        return  configUtils;
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("baseURL");
        if(baseUrl!= null) return baseUrl;

        throw new RuntimeException("the baseURL property isn't exists");
    }

    public String getEmail(){
        String email =  properties.getProperty("email");
        if(email!= null) return email;

        throw new RuntimeException("the email property isn't exists");
    }

    public String getPassword(){
        String pass= properties.getProperty("password");
        if(pass!= null) return pass;

        throw new RuntimeException("the password property isn't exists");
    }
}
