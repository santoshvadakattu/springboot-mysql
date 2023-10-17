package com.example.accessingdatamysql;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalaryExporter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long salary;

	private long salaryForCurrentMonth;
	private String empName;
	private long employeeID;

	private long arrearSal;
	private long taxSlabPercent;
	private long tds;
	private long salAfterAllDeductions;

	private Date doj;
	private long leavesTaken;
	private long totalLeaves;
	private long availableLeaves;

	private long panNumber;
	private long salReceiverName;

	private long numOfWorkingDays;
	private long numOfTotDays;
	private long numOfDaysToBePaid;
	private long totHolidaysInMonth;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long l) {
		this.employeeID = l;
	}

	public long getTotHolidaysInMonth() {
		return totHolidaysInMonth;
	}

	public void setTotHolidaysInMonth(long totHolidaysInMonth) {
		this.totHolidaysInMonth = totHolidaysInMonth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getLeavesTaken() {
		return leavesTaken;
	}

	public void setLeavesTaken(long leavesTaken) {
		this.leavesTaken = leavesTaken;
	}

	public long getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(long totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public long getAvailableLeaves() {
		return availableLeaves;
	}

	public void setAvailableLeaves(long availableLeaves) {
		this.availableLeaves = availableLeaves;
	}

	public long getArrearSal() {
		return arrearSal;
	}

	public void setArrearSal(long arrearSal) {
		this.arrearSal = arrearSal;
	}

	public long getTaxSlabPercent() {
		return taxSlabPercent;
	}

	public void setTaxSlabPercent(long taxSlabPercent) {
		this.taxSlabPercent = taxSlabPercent;
	}

	public long getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(long panNumber) {
		this.panNumber = panNumber;
	}

	public long getSalReceiverName() {
		return salReceiverName;
	}

	public void setSalReceiverName(long salReceiverName) {
		this.salReceiverName = salReceiverName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public long getNumOfWorkingDays() {
		return numOfWorkingDays;
	}

	public void setNumOfWorkingDays(long numOfWorkingDays) {
		this.numOfWorkingDays = numOfWorkingDays;
	}

	public long getNumOfTotDays() {
		return numOfTotDays;
	}

	public void setNumOfTotDays(long numOfTotDays) {
		this.numOfTotDays = numOfTotDays;
	}

	public long getNumOfDaysToBePaid() {
		return numOfDaysToBePaid;
	}

	public void setNumOfDaysToBePaid(long numOfDaysToBePaid) {
		this.numOfDaysToBePaid = numOfDaysToBePaid;
	}

	public long getTds() {
		return tds;
	}

	public void setTds(long tds) {
		this.tds = tds;
	}

	public long getSalAfterAllDeductions() {
		return salAfterAllDeductions;
	}

	public void setSalAfterAllDeductions(long salAfterAllDeductions) {
		this.salAfterAllDeductions = salAfterAllDeductions;
	}

	public long getSalaryForCurrentMonth() {
		return salaryForCurrentMonth;
	}

	public void setSalaryForCurrentMonth(long salaryForCurrentMonth) {
		this.salaryForCurrentMonth = salaryForCurrentMonth;
	}
}
