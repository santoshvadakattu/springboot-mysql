package com.example.accessingdatamysql;

 

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 

@Entity
public class Salaries1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

 

	private int id;
	private String name;
	private LocalDate doj;
	private LocalDate paydate;
	private String payperiod;
	private long pfnumber;
	private String designation;
	private long bankaccountnumber;



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

	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalDate getPaydate() {
		return paydate;
	}
	public void setPaydate(LocalDate paydate) {
		this.paydate = paydate;
	}
	public String getPayperiod() {
		return payperiod;
	}
	public void setPayperiod(String payperiod) {
		this.payperiod = payperiod;
	}
	public long getPfnumber() {
		return pfnumber;
	}
	public void setPfnumber(long pfnumber) {
		this.pfnumber = pfnumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(long bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}


}	