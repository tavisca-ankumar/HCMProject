package com.tavisca.container;

public class EmployeeAppraisalForm {

    private int empNo;
    private int qualityOfWork;
    private int attendance;
    private int initiative;
    private String remark;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getQualityOfWork() {
        return qualityOfWork;
    }

    public void setQualityOfWork(int qualityOfWork) {
        this.qualityOfWork = qualityOfWork;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
