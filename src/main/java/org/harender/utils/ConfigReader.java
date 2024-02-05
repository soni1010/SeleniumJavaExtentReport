package org.harender.utils;

import java.io.*;
import java.util.*;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
              // return;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
