package EmployeeManagement;

import java.io.Serializable;

public class Employee implements Serializable {
    private String id;
    private String name;
    private int age;
    private String sex;
    private String hometown;
    private double wage;

    public Employee() {
    }

    public Employee(String id, String name, int age, String sex, String hometown, double wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hometown = hometown;
        this.wage = wage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", hometown='" + hometown + '\'' +
                ", wage=" + wage +
                '}';
    }
}
