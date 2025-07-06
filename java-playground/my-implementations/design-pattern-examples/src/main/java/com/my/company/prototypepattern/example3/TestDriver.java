package com.my.company.prototypepattern.example3;

import java.util.List;

public class TestDriver {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");

        Employees empsNew1 = (Employees) emps.clone();
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}
