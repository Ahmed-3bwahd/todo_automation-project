package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties readFile(String filePath)  {
        File file = new File(filePath);
        try {
            InputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

            return properties;

        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }

    }
}
