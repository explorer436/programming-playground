package com.my.company.proxypattern.example1;

// grants authorization to the particular employee
public class EmployeeInternetAccess implements InternetAccess {
    private String employeeName;

    @Override
    public void grantInternetAccessToEmployees() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }

    public EmployeeInternetAccess(String empName) {
        this.employeeName = empName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
