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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverProgram {

    BufferedReader br = UserReader.getInstance();
    DataManager dataManager;

    public void executeApplication(){
        EmployeeOperator employeeOperator = new EmployeeOperator();

        try(BufferedReader br = UserReader.getInstance()) {
            System.out.println("Enter your employee Id");
            int empNo = Integer.parseInt(br.readLine());

            Employee employee = employeeOperator.findByEmpNo(empNo);
            dataManager = EmployeeFactory.getDataManager(employee);

            int choice = Integer.parseInt(br.readLine());
            System.out.println("Choose the option");
            System.out.println("1. View Employee");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");


            switch (choice){
                case 1:
                    handleView();
                    break;

                case 2:
                    if(dataManager instanceof EmployeeDataManager){
                        System.out.println("You can't add Employee." +
                                " Contact HR for more info");
                    }
                    else if(dataManager instanceof HRDataManager){
                        addEmployee();
                    }
                    break;

                case 3:
                    if(dataManager instanceof EmployeeDataManager){
                        updateEmployee(employee);
                    }
                    else if(dataManager instanceof HRDataManager){
                        int empToBeUpdated = Integer.parseInt(br.readLine());
                        Employee employeeToBeUpdated = dataManager.findByEmpNo(empToBeUpdated);

                        updateEmployee(employeeToBeUpdated);
                    }
                    break;

                case 4:
                    if(dataManager instanceof EmployeeDataManager){
                        System.out.println("You can't delete Employee." +
                                " Contact HR for more info");
                    }
                    else if(dataManager instanceof HRDataManager){
                        deleteEmployee();
                    }
                    break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void handleView() throws IOException, SQLException {

        System.out.println();
        System.out.println("Choose the option for view");
        System.out.println("1. View By Employee No");
        System.out.println("2. View By Employee Name");
        System.out.println("3. View By Department");
        System.out.println("4. View By Skill");

        int choice = Integer.parseInt(br.readLine());

        switch (choice){
            case 1:
                int empNo = Integer.parseInt(br.readLine());
                System.out.println(dataManager.findByEmpNo(empNo));
                break;

            case 2:
                String empName = br.readLine();
                System.out.println(dataManager.findByEmpName(empName));
                break;

            case 3:
                String department = br.readLine();
                System.out.println(dataManager.findByDepartment(department));
                break;

            case 4:
                String skill = br.readLine();
                System.out.println(dataManager.findBySkill(skill));
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }


    private void updateEmployee(Employee employee) throws IOException, SQLException {
        System.out.println();
        System.out.println("Choose the option for Update");
        System.out.println("1. Update By Employee Name");
        System.out.println("2. Update By Department");
        System.out.println("3. Update By Skill");

        int choice = Integer.parseInt(br.readLine());

        switch (choice){
            case 1:
                String empName = br.readLine();
                System.out.println(dataManager.updateEmployeeName(employee.getEmpNo(), empName));
                break;

            case 2:
                String department = br.readLine();
                System.out.println(dataManager.updateEmployeeDepartment(employee.getEmpNo(), department));
                break;

            case 3:
                String skill = br.readLine();
                System.out.println(dataManager.updateEmployeeSkillSet(employee.getEmpNo(), skill));
                break;

            default:
                System.out.println("Invalid Choice");
        }

    }

    private void deleteEmployee() throws SQLException, IOException {
        System.out.println("Enter Emp No to delete : ");
        int empNo = Integer.parseInt(br.readLine());
        dataManager.deleteEmployee(empNo);
    }

    private void addEmployee() throws IOException, SQLException {

        System.out.println("Enter EmpNo : ");
        int empNo = Integer.parseInt(br.readLine());

        System.out.println("Enter EmpName : ");
        String empName = br.readLine();

        System.out.println("Enter Emp Department : ");
        String department = br.readLine();

        System.out.println("Enter comma separated skills : ");
        String skills = br.readLine();

        Set<String> skillSet = (Arrays.stream(skills.split(", "))
                .collect(Collectors.toSet()));

        Employee employee = new Employee(empNo, empName, department, skillSet);

        dataManager.addEmployee(employee);
    }
}
