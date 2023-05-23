package com.my.company.proxypattern.example1;

public class TestDriver {

    public static final String EMPLOYEE_NAME = "Bruce Wayne";

    public static void main(String[] args) {
        InternetAccess internetAccess = new ProxyEmployeeInternetAccess(EMPLOYEE_NAME);
        internetAccess.grantInternetAccessToEmployees();
    }
}
