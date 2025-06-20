package com.my.company.staticexample;

public class TestDriver {

    GFG_Outer nonStaticVariableForOuterObj = new GFG_Outer();

    // Main driver method
    public static void main(String[] args) {

        // Printing value of x in the main() method
        System.out.println(GFG_Outer.x);

        // Cannot access non-static members of the class.
        // System.out.println(GFG_Outer.y);

        // Calling display() method from class 1
        GFG_Outer.displayX();

        GFG_Outer staticVariableForOuterObj = new GFG_Outer();
        staticVariableForOuterObj.displayY();

        // static inner class object which is as follows:
        // OuterClass.InnerClass variable = new OuterClass.InnerClass();
        GFG_Outer.GFG_Inner innerObj = new GFG_Outer.GFG_Inner();

        // This will not work
        // GFG_Outer.GFG_Inner innerObj = outerObj.GFG_Inner();
    }

    public void getNonStaticVariablesFromOuterClass() {
        nonStaticVariableForOuterObj.displayY();
    }
}
