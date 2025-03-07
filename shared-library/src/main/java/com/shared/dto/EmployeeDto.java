package com.shared.dto;

public class EmployeeDto {
    private int empId;
    private String empName;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public EmployeeDto(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public EmployeeDto() {
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }
}
