package com.my.company.dynamicdispatch;

public class TestDriver {

    public static void main(String[] args) {
        A testObject = new B();

        System.out.println("x: " + testObject.x); // 10

        testObject.draw(); // calls B's draw, polymorphic
        testObject.spin(); // calls A's spin, inherited by B

        // compiler error, you are manipulating this as an A
        // testObject.bad();
    }
}
