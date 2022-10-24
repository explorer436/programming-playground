package com.my.company.collections;

public class Person {

    public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.gender = sex;
	}

	String name;
    int age;
    String gender;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}
