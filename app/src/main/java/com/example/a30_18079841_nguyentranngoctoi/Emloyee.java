package com.example.a30_18079841_nguyentranngoctoi;

public class Emloyee {
    private String id;
    private String name;
    private String age;
    private String department;

    public Emloyee(String id, String name, String age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}