package com.tavisca.main;

import com.tavisca.container.Employee;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.datamanagement.EmployeeDataManager;
import com.tavisca.datamanagement.HRDataManager;
import com.tavisca.factory.EmployeeFactory;
import com.tavisca.operation.EmployeeOperator;
import com.tavisca.service.UserReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class DriverProgram {

    private DataManager dataManager;
    BufferedReader br = UserReader.getInstance();

    public void executeApplication() throws SQLException {
        EmployeeOperator employeeOperator = new EmployeeOperator();

        try{
            System.out.println("Enter your employee Id");
            int empNo = Integer.parseInt(br.readLine());

            Employee employee = employeeOperator.findByEmpNo(empNo);
            dataManager = EmployeeFactory.getDataManager(employee);

//            ReviewerDriver reviewerDriver = new ReviewerDriver(dataManager);
//            if(dataManager instanceof ReviewerDriver){
//                reviewerDriver.reviewFrom(employee);
//            }

            //Need some update for employee and HR separation coding

            boolean loginFlag = true;
            while(loginFlag) {
                loginFlag = viewEmployeeOptions(employee);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean viewEmployeeOptions(Employee employee) throws IOException, SQLException {
        DriverEmployee driverEmployee = new DriverEmployee(dataManager);

        System.out.println("Choose the option");
        System.out.println("1. View Employee");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. File Appraisal Form");
        System.out.println("6. Logout");

        int choice = Integer.parseInt(br.readLine());

        switch (choice){
            case 1:
                driverEmployee.handleView();
                break;

            case 2:
                if(dataManager instanceof EmployeeDataManager){
                    System.out.println("You can't add Employee." +
                            " Contact HR for more info");
                }
                else if(dataManager instanceof HRDataManager){
                    driverEmployee.addEmployee();
                }
                break;

            case 3:
                if(dataManager instanceof EmployeeDataManager){
                    System.out.println("Edit Your Details : ");
                    driverEmployee.updateEmployee(employee);
                }
                else if(dataManager instanceof HRDataManager){
                    System.out.println("Enter Employee No to update : ");
                    int empToBeUpdated = Integer.parseInt(br.readLine());
                    Employee employeeToBeUpdated = dataManager.findByEmpNo(empToBeUpdated);

                    driverEmployee.updateEmployee(employeeToBeUpdated);
                }
                break;

            case 4:
                if(dataManager instanceof EmployeeDataManager){
                    System.out.println("You can't delete Employee." +
                            " Contact HR for more info");
                }
                else if(dataManager instanceof HRDataManager){
                    driverEmployee.deleteEmployee();
                }
                break;

            case 5:
                driverEmployee.fillAppraisalForm(employee.getEmpNo());
                break;

            default:
                System.out.println("Logged Out");
                return false;
        }
        return true;
    }
}
