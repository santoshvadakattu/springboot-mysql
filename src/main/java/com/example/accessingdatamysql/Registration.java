package com.example.accessingdatamysql;

import java.time.LocalDate;
import java.util.List;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String firstName;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	private String surname;
    private String sex;
    private String email;
    private String primaryMobile;
    private String secondaryMobile;
    private String address;
    private String landmark;
    private Long zipCode;
    private LocalDate doj;
    private String aadhar;
    private String projectName;
    private LocalDate projectAllocationDate;
    private double monthlySalary;
    private Integer workAllocationDays;
    private List<String> workType;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
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
	public Integer getWorkAllocationDays() {
		return workAllocationDays;
	}
	public void setWorkAllocationDays(Integer workAllocationDays) {
		this.workAllocationDays = workAllocationDays;
	}
	public List<String> getWorkType() {
		return workType;
	}
	public void setWorkType(List<String> workType) {
		this.workType = workType;
	}

 

   
}