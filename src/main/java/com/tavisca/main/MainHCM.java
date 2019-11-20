package com.tavisca.main;

import com.tavisca.container.Employee;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.datamanagement.EmployeeDataManager;
import com.tavisca.factory.EmployeeFactory;
import com.tavisca.operation.EmployeeOperator;
import com.tavisca.service.UserReader;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainHCM {

    public static void main(String[] args) {
        DriverProgram driverProgram = new DriverProgram();
        driverProgram.executeApplication();
    }
}
