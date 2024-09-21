package com.mystore.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    String path = "configuration/config.properties";
    Properties properties;

    public ReadConfig(){
        try{
            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getBaseURL(){
        String url = properties.getProperty("url");

        if(url!=null){
            return url;
        }else{
            throw new RuntimeException("url not specified in config file!");
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");

        if(browser!=null){
            return browser;
        }else{
            throw new RuntimeException("Browser not specified in config file!");
        }
    }

    public String getUserName(){
        String userName = properties.getProperty("username");

        if(userName!=null){
            return userName;
        }else{
            throw new RuntimeException("Username not specified in config file!");
        }
    }

    public String getPassword(){
        String password = properties.getProperty("password");

        if(password!=null){
            return password;
        }else{
            throw new RuntimeException("Password not specified in config file!");
        }
    }
}
