package com.example.accessingdatamysql;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employeeinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
    private String surname;
	private String primaryMobile;
private String secondaryMobile;
private String email;
private LocalDate doj;
private String projectName;
private LocalDate projectAllocationDate;
private double monthlySalary;
private List<String> workType;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getfirstName() {
	return firstName;
}
public void setfirstName(String firstName) {
	this.firstName = firstName;
}

public String getsurname() {
	return surname;
}

public void setsurname(String surname) {
	this.surname=surname;
}

public String getPrimaryMobile() {
	return primaryMobile;
}
public void setPrimaryMobile(String primaryMobile) {
	this.primaryMobile = primaryMobile;
}
public String getSecondaryMobile() {
	return secondaryMobile;
}
public void setSecondaryMobile(String secondaryMobile) {
	this.secondaryMobile = secondaryMobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getDoj() {
	return doj;
}
public void setDoj(LocalDate doj) {
	this.doj = doj;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public LocalDate getProjectAllocationDate() {
	return projectAllocationDate;
}
public void setProjectAllocationDate(LocalDate projectAllocationDate) {
	this.projectAllocationDate = projectAllocationDate;
}
public double getMonthlySalary() {
	return monthlySalary;
}
public void setMonthlySalary(double monthlySalary) {
	this.monthlySalary = monthlySalary;
}
public List<String> getWorkType() {
	return workType;
}
public void setWorkType(List<String> workType) {
	this.workType = workType;
}

	

	

}
