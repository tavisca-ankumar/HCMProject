package com.tavisca.main;

import com.tavisca.container.Employee;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.factory.EmployeeFactory;
import com.tavisca.operation.EmployeeOperator;
import com.tavisca.service.UserReader;

import java.io.*;
import java.sql.SQLException;

public class MainHCM {
    public static void main(String[] args) {

        EmployeeOperator employeeOperator = new EmployeeOperator();

        try(BufferedReader br = UserReader.getInstance()) {
            System.out.println("Enter your employee Id");
            int empNo = Integer.parseInt(br.readLine());

            Employee employee = employeeOperator.findByEmpNo(empNo);
            DataManager dataManager = EmployeeFactory.getDataManager(employee);

//            if(dataManager instanceof  HRDataManager){
//
//            }
//            else if(dataManager instanceof EmployeeDataManager){
//
//            }

            int choice = Integer.parseInt(br.readLine());
            System.out.println("Choose the option");
            System.out.println("1. View Employee");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");


            switch (choice){
                case 1:

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
