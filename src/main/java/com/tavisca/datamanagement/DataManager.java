package com.tavisca.datamanagement;

import com.tavisca.container.Employee;

import java.sql.SQLException;
import java.util.List;

public interface DataManager {

    Employee findByEmpNo(int empNo) throws SQLException;

    List<Employee> findByEmpName(String empName) throws SQLException;

    List<Employee> findByDepartment(String department) throws SQLException;

    List<Employee> findBySkill(String skill) throws SQLException;

    boolean updateEmployeeSkillSet(int empNo, String skill) throws SQLException;

    boolean updateEmployeeName(int empNo, String empName) throws SQLException;

    boolean updateEmployeeDepartment(int empNo, String department) throws SQLException;

    boolean deleteEmployee(int empNo) throws SQLException;
    boolean addEmployee(Employee employee) throws SQLException;
}
