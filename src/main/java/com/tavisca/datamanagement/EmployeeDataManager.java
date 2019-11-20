package com.tavisca.datamanagement;

import com.tavisca.container.Employee;
import com.tavisca.service.UserReader;

import java.io.BufferedReader;

public class EmployeeDataManager extends DataManagerAdaptor{

    @Override
    public boolean deleteEmployee(int empNo) {
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }
}
