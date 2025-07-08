package com.my.company.functionainterfacewithreturntype;

public class DriverUsingLambdaExpression2 {
    public static void main(String[] args) {
        /*A obj = new A() {
            @Override
            public void show() {
                System.out.println("In show()");
            }
        };
        obj.show();*/

        // Remove the boilerplate code
        // The use of new() is boilerplate
        // The name of the method is boilerplate

        // Make sure you use "->". That represents lambda.

        // A obj = (int i) -> System.out.println("In show() - i: " + i);
        // A obj = (i) -> System.out.println("In show() - i: " + i);
        A2 obj = (i, j) -> i + j;
        System.out.println(obj.add(7, 8));
    }
}
