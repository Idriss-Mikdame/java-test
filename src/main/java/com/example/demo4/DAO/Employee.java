package com.example.demo4.DAO;

public class Employee {
    int id;
    String name;
    String city ;
    String jbob;
    double salary;


    public Employee(int id, String name, String city, String jbob, double salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.jbob = jbob;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJbob() {
        return jbob;
    }

    public void setJbob(String jbob) {
        this.jbob = jbob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", jbob='" + jbob + '\'' +
                ", salary=" + salary +
                '}';
    }
}
