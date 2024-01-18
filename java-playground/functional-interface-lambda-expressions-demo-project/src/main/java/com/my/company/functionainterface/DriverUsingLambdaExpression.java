package com.my.company.functionainterface;

public class DriverUsingLambdaExpression {
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
        A obj = (i) -> System.out.println("In show() - i: " + i);
        /*A obj = i -> {
            System.out.println("In show() - i: " + i);
        };*/
        obj.show(7);
    }
}
