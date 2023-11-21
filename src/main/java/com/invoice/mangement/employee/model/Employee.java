package com.invoice.mangement.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    Long uuid;

    @Column(name = "project_uuid")
    Long projectUuid;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "position")
    String position;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "email_address")
    String emailAddress;

    @Column(name = "salary")
    Long salary;

    public Employee() {
    }

    public Employee(Long projectUuid, String firstName, String lastName, String position, String phoneNumber, String emailAddress, Long salary) {
        this.projectUuid = projectUuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.salary = salary;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getProjectUuid() {
        return projectUuid;
    }

    public void setProjectUuid(Long projectUuid) {
        this.projectUuid = projectUuid;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uuid=" + uuid +
                ", projectUuid=" + projectUuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", salary=" + salary +
                '}';
    }
}

