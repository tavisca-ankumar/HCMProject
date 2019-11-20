package com.tavisca.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserReader {

    static BufferedReader br;

    public static BufferedReader getInstance()  {
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        return br;
    }

}
