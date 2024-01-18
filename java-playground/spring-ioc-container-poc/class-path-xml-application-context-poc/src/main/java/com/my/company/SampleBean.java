package com.my.company;

import lombok.Setter;

@Setter
public class SampleBean {

    private String sampleProperty;

    public void methodInSampleBean(){
        System.out.println("I am listening...");
        System.out.println("sampleProperty in SampleBean is: " + sampleProperty);
    }

}
