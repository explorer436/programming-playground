package com.my.company.decoratorpattern.example2;

public class RoseBouquet extends FlowerBouquet{
    public RoseBouquet(){
        description = "Rose bouquet";
    }
    public  double cost(){
        return 12.0;
    }
}
