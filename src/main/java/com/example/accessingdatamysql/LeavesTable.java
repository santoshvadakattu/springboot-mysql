package com.example.accessingdatamysql;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeavesTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long yearNumber;
	private long monthNumber;
	private long empId;
	private Date leaveFromDate;
	private Date leaveToDate;
	private String leaveFrom;
	private String leaveTo;
	private long leavesCount;
	private long numOfWorkingDays;
	private long numOfTotDays;
	private long numOfDaysToBePaid;
	private long totHolidaysInMonth;

	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public Date getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public Date getLeaveToDate() {
		return leaveToDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLeavesCount() {
		return leavesCount;
	}

	public void setLeavesCount(long leavesCount) {
		this.leavesCount = leavesCount;
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

	public String getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}

}
