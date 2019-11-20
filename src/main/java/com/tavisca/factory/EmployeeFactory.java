package com.tavisca.factory;

import com.tavisca.container.Employee;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.datamanagement.EmployeeDataManager;
import com.tavisca.datamanagement.HRDataManager;
import com.tavisca.operation.EmployeeOperator;

import java.sql.SQLException;

public class EmployeeFactory {

    public static DataManager getDataManager(Employee employee) throws SQLException {

        if(employee.getDepartment().equalsIgnoreCase("HR")){
            return new HRDataManager();
        }
        else if(employee.getDepartment().equalsIgnoreCase("Employee")){
            return new EmployeeDataManager();
        }
        else
            return null; // will be updated
    }
}
