package com.myclass.entity;

import java.util.Date;

public class Task {
	private int id;
	private String name;
	private Date endDate;
	private int group_id;
	private int account_id;
	private int status_id;

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String name, Date endDate, int group_id, int account_id, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.endDate = endDate;
		this.group_id = group_id;
		this.account_id = account_id;
		this.status_id = status_id;
	}

	public Task(int id, String name, Date endDate, int account_id, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.endDate = endDate;
		this.account_id = account_id;
		this.status_id = status_id;
	}

	public Task(String name, Date endDate, int group_id, int account_id, int status_id) {

		this.name = name;
		this.endDate = endDate;
		this.group_id = group_id;
		this.account_id = account_id;
		this.status_id = status_id;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", endDate=" + endDate + ", group_id=" + group_id + ", account_id="
				+ account_id + ", status_id=" + status_id + "]";
	}

}
