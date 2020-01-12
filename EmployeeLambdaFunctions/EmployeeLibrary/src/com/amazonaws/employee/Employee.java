package com.amazonaws.employee;

public class Employee {
	
	public Employee() {
		
	}

	private String id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", age=" + getAge()
				+ ", gender=" + getGender() + "]";
	}

	

}
