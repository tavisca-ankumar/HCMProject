package com.tavisca.datamanagement;

import com.tavisca.container.Employee;

public class HRDataManager implements DataManager {

    Employee employee;

    public HRDataManager(Employee emp){
        this.employee = emp;
    }

    @Override
    public void viewEmployee() {

    }

    @Override
    public boolean updateEmployee() {
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
