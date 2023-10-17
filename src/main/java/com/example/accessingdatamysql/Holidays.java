package com.example.accessingdatamysql;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Holidays {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    private LocalDate date;
    private LocalDate fromDate;
    private LocalDate toDate;
    
    public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	private String eventName;

    // Constructors, getters, and setters

    public Holidays() {
        // Default constructor
    }

    public Holidays(LocalDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
