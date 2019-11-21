package com.tavisca.main;

import com.tavisca.container.Employee;
import com.tavisca.container.EmployeeAppraisalForm;
import com.tavisca.datamanagement.DataManager;
import com.tavisca.service.UserReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverEmployee {

    private BufferedReader br = UserReader.getInstance();
    private DataManager dataManager;

    public DriverEmployee(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void handleView() throws IOException, SQLException {

        System.out.println();
        System.out.println("Choose the option for view");
        System.out.println("1. View By Employee No");
        System.out.println("2. View By Employee Name");
        System.out.println("3. View By Department");
        System.out.println("4. View By Skill");

        int choice = Integer.parseInt(br.readLine());

        switch (choice){
            case 1:
                System.out.println("Enter Employee No : ");
                int empNo = Integer.parseInt(br.readLine());
                System.out.println(dataManager.findByEmpNo(empNo));
                break;

            case 2:
                System.out.println("Enter Employee Name : ");
                String empName = br.readLine();
                System.out.println(dataManager.findByEmpName(empName));
                break;

            case 3:
                System.out.println("Enter Department : ");
                String department = br.readLine();
                System.out.println(dataManager.findByDepartment(department));
                break;

            case 4:
                System.out.println("Enter Skill : ");
                String skill = br.readLine();
                System.out.println(dataManager.findBySkill(skill));
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    public void updateEmployee(Employee employee) throws IOException, SQLException {
        System.out.println();
        System.out.println("Choose the option for Update");
        System.out.println("1. Update Employee Name");
        System.out.println("2. Update Department");
        System.out.println("3. Update Skill");

        int choice = Integer.parseInt(br.readLine());

        switch (choice){
            case 1:
                System.out.println("Enter Name to be updated : ");
                String empName = br.readLine();
                dataManager.updateEmployeeName(employee.getEmpNo(), empName);
                break;

            case 2:
                System.out.println("Enter department to be updated : ");
                String department = br.readLine();
                dataManager.updateEmployeeDepartment(employee.getEmpNo(), department);
                break;

            case 3:
                System.out.println("Enter skill to be added : ");
                String skill = br.readLine();
                dataManager.updateEmployeeSkillSet(employee.getEmpNo(), skill);
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    public void deleteEmployee() throws SQLException, IOException {
        System.out.println("Enter Emp No to delete : ");
        int empNo = Integer.parseInt(br.readLine());
        dataManager.deleteEmployee(empNo);
    }

    public void addEmployee() throws IOException, SQLException {

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

    public void fillAppraisalForm(int empNo) throws IOException, SQLException {
        System.out.println("Rate in qualityOfWork");
        int qualityOfWork = Integer.parseInt(br.readLine());

        System.out.println("Rate in attendance");
        int attendance = Integer.parseInt(br.readLine());

        System.out.println("Rate in initiative");
        int initiative = Integer.parseInt(br.readLine());

        EmployeeAppraisalForm employeeAppraisalForm = new EmployeeAppraisalForm(empNo, qualityOfWork, attendance, initiative, null);
        dataManager.fillAppraisalForm(employeeAppraisalForm);
    }
}
