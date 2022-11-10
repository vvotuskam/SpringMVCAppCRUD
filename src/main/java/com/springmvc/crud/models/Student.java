package com.springmvc.crud.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Student {

    private int id;
    @Size(min = 2, max = 30, message = "Invalid name")
    private String name;
    @Min(value = 0, message = "Must be between 0 and 4.0")
    @Max(value = 4)
    private double gpa;

    public Student() {

    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
