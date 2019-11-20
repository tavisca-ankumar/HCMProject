package com.tavisca.datamanagement;

import com.tavisca.container.Employee;
import com.tavisca.database.EmployeeCrudOperation;
import com.tavisca.operation.EmployeeOperator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataManagerAdaptor implements DataManager{

    private EmployeeCrudOperation employeeCrudOperation;

    public DataManagerAdaptor(){
        employeeCrudOperation = new EmployeeCrudOperation();
    }

    public EmployeeCrudOperation getEmployeeCrudOperation() {
        return employeeCrudOperation;
    }

    public void setEmployeeCrudOperation(EmployeeCrudOperation employeeCrudOperation) {
        this.employeeCrudOperation = employeeCrudOperation;
    }

    @Override
    public Employee findByEmpNo(int empNo) throws SQLException {
        return employeeCrudOperation.findByEmpNo(empNo);
    }

    @Override
    public ArrayList<Employee> findByEmpName(String empName) throws SQLException {
        return employeeCrudOperation.findByName(empName);
    }

    @Override
    public ArrayList<Employee> findByDepartment(String department) throws SQLException {
        return employeeCrudOperation.findByDepartment(department);
    }

    @Override
    public ArrayList<Employee> findBySkill(String skill) throws SQLException {
        return employeeCrudOperation.findBySkill(skill);
    }

    @Override
    public boolean updateEmployeeSkillSet(int empNo, String skill) throws SQLException {
        return employeeCrudOperation.updateEmployeeSkillSet(empNo,skill);
    }

    @Override
    public boolean updateEmployeeName(int empNo, String empName) throws SQLException {
        return employeeCrudOperation.updateEmployeeName(empNo,empName);
    }

    @Override
    public boolean updateEmployeeDepartment(int empNo, String department) throws SQLException {
        return employeeCrudOperation.updateEmployeeDepartment(empNo,department);
    }
}