package com.training.model.entrepriseExample;


import java.util.List;

public class Manager {
    String name;
    List<Employee> employeeList;

    public Manager(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
