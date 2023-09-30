package com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList;

public class EmployeeNode {

  private Employee employee;
  private EmployeeNode next;
  private EmployeeNode previous;

  public EmployeeNode() {
    super();
  }

  public EmployeeNode(Employee employee) {
    super();
    this.employee = employee;
  }

  @Override
  public String toString() {
    return employee.toString();
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public EmployeeNode getNext() {
    return next;
  }

  public void setNext(EmployeeNode next) {
    this.next = next;
  }

  public EmployeeNode getPrevious() {
    return previous;
  }

  public void setPrevious(EmployeeNode previous) {
    this.previous = previous;
  }

  public class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
    }
  }
}
