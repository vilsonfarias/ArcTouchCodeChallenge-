package com.example.user01.myapplication.model.pojo.internal;

import java.util.List;

public class ResponseWrapper<T> {
	private List<T> rows;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
