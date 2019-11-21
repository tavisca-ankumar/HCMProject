package com.tavisca.database;

import com.tavisca.container.EmployeeAppraisalForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAppraisalDbOperation {

    private Connection conn;

    public EmployeeAppraisalDbOperation() {
        try {
            conn = DatabaseConnectivityCreator.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addAppraisal(EmployeeAppraisalForm employeeAppraisalForm) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into appraisal values" +
                "(?,?,?,?,?)");
        preparedStatement.setInt(1, employeeAppraisalForm.getEmpNo());
        preparedStatement.setInt(2, employeeAppraisalForm.getQualityOfWork());
        preparedStatement.setInt(3, employeeAppraisalForm.getAttendance());
        preparedStatement.setInt(4, employeeAppraisalForm.getInitiative());
        preparedStatement.setString(5, employeeAppraisalForm.getRemark());
        return preparedStatement.execute();
    }

    public EmployeeAppraisalForm findByEmpNo(int empNo) throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from employee where empNo=?");
        st.setInt(1, empNo);
        ResultSet rs = st.executeQuery();
        rs.next();
        EmployeeAppraisalForm tempEmployee = setEmployeeDetails(rs);
        return tempEmployee;
    }

    public EmployeeAppraisalForm setEmployeeDetails(ResultSet rs) throws SQLException {
        EmployeeAppraisalForm tempEmployeeAppraisalFrom = new EmployeeAppraisalForm(rs.getInt(1),
                rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
        return tempEmployeeAppraisalFrom;
    }
}
