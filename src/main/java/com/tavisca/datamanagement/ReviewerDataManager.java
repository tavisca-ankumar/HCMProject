package com.tavisca.datamanagement;

import com.tavisca.container.EmployeeAppraisalForm;
import com.tavisca.database.EmployeeAppraisalDbOperation;

import java.sql.SQLException;

public class ReviewerDataManager extends EmployeeDataManager {

    private EmployeeAppraisalDbOperation employeeAppraisalDbOperation;

    public ReviewerDataManager(){
        employeeAppraisalDbOperation = new EmployeeAppraisalDbOperation();
    }

    public EmployeeAppraisalForm viewAppraisalForm(int empNo) throws SQLException {
        return employeeAppraisalDbOperation.findByEmpNo(empNo);
    }
}
