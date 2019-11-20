package com.tavisca.container;

import java.util.Set;

public class Employee {
    private int empNo;
    private String empName;
    private String department;
    private Set<String> skillSet;

    public Employee() {
    }

    public Employee(int empNo, String empName, String department, Set<String> skillSet) {
        this.empNo = empNo;
        this.empName = empName;
        this.department = department;
        this.skillSet = skillSet;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<String> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", skillSet=" + skillSet +
                '}';
    }
}
