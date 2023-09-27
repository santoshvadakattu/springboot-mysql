package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentsTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long yearNumber;
	private long monthNumber;
	private long empId;
	private long salaryForCurrentMonth;
	private long tds;
	private long salAfterAllDeductions;
	private long numOfLeavesTakenInAMonth;
	private long numOfWorkingDays;
	private long numOfTotDays;
	private long numOfDaysToBePaid;
	private long totHolidaysInMonth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumOfLeavesTakenInAMonth() {
		return numOfLeavesTakenInAMonth;
	}

	public void setNumOfLeavesTakenInAMonth(long numOfLeavesTakenInAMonth) {
		this.numOfLeavesTakenInAMonth = numOfLeavesTakenInAMonth;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getEmpId() {
		return empId;
	}

	public long getYearNumber() {
		return yearNumber;
	}

	public void setYearNumber(long yearNumber) {
		this.yearNumber = yearNumber;
	}

	public long getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(long monthNumber) {
		this.monthNumber = monthNumber;
	}

	public long getTotHolidaysInMonth() {
		return totHolidaysInMonth;
	}

	public void setTotHolidaysInMonth(long totHolidaysInMonth) {
		this.totHolidaysInMonth = totHolidaysInMonth;
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
