package com.example.accessingdatamysql;

public class LeavesExorter {
	private long empId;
	private long yearNumber;
	private long monthNumber;
	private long numOfWorkingDays;
	private long numOfTotDays;
	private long numOfDaysToBePaid;
	private long totHolidaysInMonth;

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
}
