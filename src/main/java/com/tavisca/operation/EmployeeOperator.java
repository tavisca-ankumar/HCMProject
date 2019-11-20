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

    public Employee searchEmpNo(int empNo) throws SQLException {
        return employeeCrudOperation.findByEmpNo(empNo);
    }

    public ArrayList<Employee> searchByEmpName(String empName) throws SQLException {
        return employeeCrudOperation.findByName(empName);
    }

    public ArrayList<Employee> searchByDepartment(String department) throws SQLException {
        return employeeCrudOperation.findByDepartment(department);
    }

    public ArrayList<Employee> searchBySkill(String skill) throws SQLException {
        return employeeCrudOperation.findBySkill(skill);
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        return employeeCrudOperation.insertEmployee(employee);
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
