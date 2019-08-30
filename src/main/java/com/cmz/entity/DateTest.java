package com.cmz.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateTest {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public DateTest() {}
	public DateTest(Date date) {
		this.date=date;
	}

	@Override
	public String toString() {
		return "DateTest [date=" + date + "]";
	}
}
