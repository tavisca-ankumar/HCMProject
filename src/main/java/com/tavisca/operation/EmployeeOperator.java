package com.tavisca.operation;

import com.tavisca.container.Employee;
import com.tavisca.database.EmployeeCrudOperation;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeOperator {

    private EmployeeCrudOperation employeeCrudOperation;

    public EmployeeOperator(){
       employeeCrudOperation = new EmployeeCrudOperation();
    }

    public Employee findByEmpNo(int empNo) throws SQLException {
        return employeeCrudOperation.findByEmpNo(empNo);
    }

    public ArrayList<Employee> findByEmpName(String empName) throws SQLException {
        return employeeCrudOperation.findByName(empName);
    }

    public ArrayList<Employee> findByDepartment(String department) throws SQLException {
        return employeeCrudOperation.findByDepartment(department);
    }

    public ArrayList<Employee> findBySkill(String skill) throws SQLException {
        return employeeCrudOperation.findBySkill(skill);
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        return employeeCrudOperation.addEmployee(employee);
    }

    public boolean deleteEmployee(int empNo) throws SQLException {
        return employeeCrudOperation.deleteEmployee(empNo);
    }

    public boolean updateEmployeeSkillSet(int empNo, String skill) throws SQLException {
        return employeeCrudOperation.updateEmployeeSkillSet(empNo,skill);
    }

    public boolean updateEmployeeName(int empNo, String empName) throws SQLException {
        return employeeCrudOperation.updateEmployeeName(empNo,empName);
    }

    public boolean updateEmployeeDepartment(int empNo, String department) throws SQLException {
        return employeeCrudOperation.updateEmployeeDepartment(empNo,department);
    }

}