package com.tavisca.database;

import com.tavisca.container.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeCrudOperation {

    private Connection conn;

    public EmployeeCrudOperation() {
        try {
            conn = DatabaseConnectivityCreator.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findByName(String empName) throws SQLException {
        ArrayList<Employee> al = new ArrayList<Employee>();
        PreparedStatement st = conn.prepareStatement("select * from employee where empName=?");
        st.setString(1, empName);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Employee tempEmployee = setEmployeeDetails(rs);
            al.add(tempEmployee);
        }
        return al;
    }

    public Employee findByEmpNo(int empNo) throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from employee where empNo=?");
        st.setInt(1, empNo);
        ResultSet rs = st.executeQuery();
        rs.next();
        Employee tempEmployee = setEmployeeDetails(rs);
        return tempEmployee;
    }

    public List<Employee> findByDepartment(String skillSet) throws SQLException {
        ArrayList<Employee> al = new ArrayList<Employee>();
        PreparedStatement st = conn.prepareStatement("select * from employee where department=?");
        st.setString(1,skillSet);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Employee tempEmployee = setEmployeeDetails(rs);
            al.add(tempEmployee);
        }
        return al;
    }

    public List<Employee> findBySkill(String skill) throws SQLException {
        ArrayList<Employee> al = new ArrayList<Employee>();
        PreparedStatement st = conn.prepareStatement("select * from employee where skillSet like ?");
        String likeSkill = "%"+skill+"%";
        st.setString(1, likeSkill);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Employee tempEmployee = setEmployeeDetails(rs);
            al.add(tempEmployee);
        }
        return al;
    }

    public Employee setEmployeeDetails(ResultSet rs) throws SQLException {
        Employee tempEmployee = new Employee();
        tempEmployee.setEmpName(rs.getString(2));
        tempEmployee.setEmpNo(rs.getInt(1));
        tempEmployee.setDepartment(rs.getString(3));
        String[] skillSets= rs.getString(4).split(", ");
        Set<String> skillSetOfEmployee = Arrays.stream(skillSets).collect(Collectors.toSet());
        tempEmployee.setSkillSet(skillSetOfEmployee);
        return tempEmployee;
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into employee values" +
                "(?,?,?,?)");
        preparedStatement.setInt(1, employee.getEmpNo());
        preparedStatement.setString(2, employee.getEmpName());
        preparedStatement.setString(3, employee.getDepartment());
        String skillSet = employee.getSkillSet().stream().collect(Collectors.joining(", "));
        preparedStatement.setString(4, skillSet);
        return preparedStatement.execute();
    }

    public boolean deleteEmployee(int empNo) throws SQLException {
        moveEmployeeToHistory(empNo);
        PreparedStatement preparedStatement = conn.prepareStatement("delete from " +
                "employee where empNo=?");
        preparedStatement.setInt(1, empNo);
        return preparedStatement.execute();
    }

    public void moveEmployeeToHistory(int empNo) throws SQLException {
        Employee employee = findByEmpNo(empNo);

        PreparedStatement preparedStatement = conn.prepareStatement("insert into employeeHistory values"+
                 "(?,?,?,?)");
        preparedStatement.setInt(1, empNo);
        preparedStatement.setString(2, employee.getEmpName());
        preparedStatement.setString(3, employee.getDepartment());
        String skillSet = employee.getSkillSet().stream().collect(Collectors.joining(", "));
        preparedStatement.setString(4, skillSet);

        preparedStatement.execute();
    }

    public boolean updateEmployeeSkillSet(int empNo, String skill) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement("update employee set skillSet=concat(skillSet, ?) " +
                "where empNo=?");
        preparedStatement.setString(1,", "+skill);
        preparedStatement.setInt(2, empNo);
        return preparedStatement.execute();
    }

    public boolean updateEmployeeName(int empNo, String empName) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement("update employee set empName=? " +
                "where empNo=?");
        preparedStatement.setString(1,empName);
        preparedStatement.setInt(2, empNo);
        return preparedStatement.execute();
    }

    public boolean updateEmployeeDepartment(int empNo, String department) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement("update employee set department = ? " +
                "where empNo=?");
        preparedStatement.setString(1, department);
        preparedStatement.setInt(2, empNo);
        return preparedStatement.execute();
    }
}
