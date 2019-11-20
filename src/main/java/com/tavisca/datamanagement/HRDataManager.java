package com.tavisca.datamanagement;

import com.tavisca.container.Employee;

import java.sql.SQLException;

public class HRDataManager extends DataManagerAdaptor{

    @Override
    public boolean deleteEmployee(int empNo) throws SQLException {
        return getEmployeeCrudOperation().deleteEmployee(empNo);
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        return getEmployeeCrudOperation().addEmployee(employee);
    }
}
