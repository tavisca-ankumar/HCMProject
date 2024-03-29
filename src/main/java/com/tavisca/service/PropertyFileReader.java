package com.tavisca.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    public Properties readPropertyFile() {

        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("resources/config.properties");


            // load a properties file
            prop.load(input);

            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        propertyFileReader.readPropertyFile();
    }

}
