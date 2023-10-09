package com.example.accessingdatamysql;
 
import java.time.LocalDate;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class EmployeePortal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String firstname;
	private String surname;
	private String emailid;
	private String sex;
	private String primarymobileno;
	private String secondarymobileno;
	private String address;
	private String landmark;
	private long zipcode;
	private LocalDate doj;
	private long aadharno;
	private String projectname;
	private LocalDate projectallocationdate;
	private long monthlysalary;
	private int workallocationdays;
	private List<String> worktype;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPrimarymobileno() {
		return primarymobileno;
	}
	public void setPrimarymobileno(String primarymobileno) {
		this.primarymobileno = primarymobileno;
	}
	public String getSecondarymobileno() {
		return secondarymobileno;
	}
	public void setSecondarymobileno(String secondarymobileno) {
		this.secondarymobileno = secondarymobileno;
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
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public long getAadharno() {
		return aadharno;
	}
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public LocalDate getProjectallocationdate() {
		return projectallocationdate;
	}
	public void setProjectallocationdate(LocalDate projectallocationdate) {
		this.projectallocationdate = projectallocationdate;
	}
	public long getMonthlysalary() {
		return monthlysalary;
	}
	public void setMonthlysalary(long monthlysalary) {
		this.monthlysalary = monthlysalary;
	}
	public int getWorkallocationdays() {
		return workallocationdays;
	}
	public void setWorkallocationdays(int workallocationdays) {
		this.workallocationdays = workallocationdays;
	}
	public List<String> getWorktype() {
		return worktype;
	}
	public void setWorktype(List<String> worktype) {
		this.worktype = worktype;
	}
}
	
	

 

   



 

