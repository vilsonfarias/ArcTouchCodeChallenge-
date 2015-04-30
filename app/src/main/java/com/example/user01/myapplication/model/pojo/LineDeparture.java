package com.example.user01.myapplication.model.pojo;

public class LineDeparture {
	private Integer id;
	private String calendar;
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("id: ").append(id).append(" | ");
		b.append("calendar: ").append(calendar).append(" | ");
		b.append("time: ").append(time);
		return b.toString();
	}
}
