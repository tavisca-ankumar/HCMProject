package com.tavisca.database;

import com.tavisca.container.EmployeeAppraisalForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
