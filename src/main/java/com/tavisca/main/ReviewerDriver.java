package com.tavisca.main;

import com.tavisca.container.Employee;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.datamanagement.ReviewerDataManager;
import com.tavisca.service.UserReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ReviewerDriver {

    private BufferedReader br;
    private DataManager dataManager;

    ReviewerDriver(DataManager dataManager){
        this.dataManager = dataManager;
        br = UserReader.getInstance();
    }

    public void editForm(){

    }

    public void fillAppraisalForm(){

    }
    public void reviewFrom(Employee employee) throws IOException {
        System.out.println("Enter the Id to review : ");
        int empNoToBeReviewed = Integer.parseInt(br.readLine());

        System.out.println("Appraisal Form of Emp " + employee.getEmpName()
                + " Id : " + employee.getEmpNo());



    }

}
