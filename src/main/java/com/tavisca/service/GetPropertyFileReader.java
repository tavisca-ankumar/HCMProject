package com.tavisca.service;

public class GetPropertyFileReader {

    private static PropertyFileReader propertyFileReader;

    public static PropertyFileReader getInstance() {
        if(propertyFileReader == null){
            propertyFileReader=new PropertyFileReader();
        }
        return propertyFileReader;
    }

}
