package com.my.company.datastructures.arrays;

public class TwoDimArrayDemo {

    public static void main(String[] args) {
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        System.out.println(names.length);
        // 2

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i][0] + names[i][1]);
        }
        // Mr. Mrs.
        // SmithJones

        System.out.println(names[0][0] + names[1][0]);
        // Mr. Smith

        System.out.println(names[0][1] + names[1][0]);
        // Mrs. Smith

        System.out.println(names[0][2] + names[1][1]);
        // Ms. Jones
    }

}
