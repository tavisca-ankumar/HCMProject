package com.tavisca.datamanagement;

import com.tavisca.container.Employee;
import com.tavisca.service.UserReader;

import java.io.BufferedReader;

public class EmployeeDataManager implements DataManager{

     Employee employee;

    public EmployeeDataManager(Employee emp){
        this.employee = emp;
    }

    @Override
    public void viewEmployee() {

    }

    @Override
    public boolean updateEmployee() {
        BufferedReader br = UserReader.getInstance();
        return false;
    }

    @Override
    public boolean deleteEmployee() {
        return false;
    }

    @Override
    public boolean addEmployee() {
        return false;
    }
}
