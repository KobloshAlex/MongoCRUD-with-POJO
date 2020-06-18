package com.cogent.info.entities;

import org.bson.types.ObjectId;

import java.util.List;

public class Student {

    private ObjectId id;
    private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer balance;
    private String password;
    private List<Course> courses;

    public ObjectId getId() {
        return id;
    }

    public Student setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public Student setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Student setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Student setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }
}
