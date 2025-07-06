package com.my.company.datastructures.linkedlist.singlyLinkedEmployeeList;

public class EmployeeNode {

  private Employee employee;
  private EmployeeNode next;

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


}
