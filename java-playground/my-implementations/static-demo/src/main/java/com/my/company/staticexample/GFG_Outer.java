package com.my.company.staticexample;

// Class 1
// Helper Class
class GFG_Outer {

    // Custom input integer value
    static int x = 20;

    int y = 50;

    public static void displayX() {
        System.out.println("x from GFG_Outer: " + x);
    }

    public void displayY() {
        System.out.println("y from GFG_Outer: " + y);
    }

    // Class 2
    // Static inner class
    // Can access all static variables of outer class
    // Can't access non-static members
    static class GFG_Inner {

        public GFG_Inner() {
            // Display message
            System.out.println("This is Inner Class Constructor...");

            // Print the value of x from inner static class
            System.out.println(
                    "x from inside Inner Class is : " + x);
        }
    }

}