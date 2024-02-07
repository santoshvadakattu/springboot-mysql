package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address1;
	private String state;
	private String city;
	private String street;

	private String depName;
	private Integer salary1;
	private String taxSlab;
	
	public String getdepName() {
		return depName;
	}
	public void setdepName(String depName) {
		this.depName=depName;
	}
	
	
	public Integer getSalary1() {
		return salary1;
	}
	public void setSalary1(Integer salary1) {
		this.salary1=salary1;
	}
	
	public String getTaxSlab() {
		return taxSlab;
	}
	public void setTaxSlab(String taxSlab) {
		this.taxSlab=taxSlab;
	}
	
	
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1=address1;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state=state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void SetStreet(String street) {
		this.street=street;
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "salary_id")
	private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}