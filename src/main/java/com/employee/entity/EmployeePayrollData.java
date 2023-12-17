package com.employee.entity;
public class EmployeePayrollData{
    int id;
    String name;
    double salary;

    public EmployeePayrollData(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString(){
        return "ID: "+ this.id + ", Name: " + this.name + ", Salary: " + this.salary;
    }
}
