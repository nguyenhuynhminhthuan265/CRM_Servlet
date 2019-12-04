package com.myclass.dto;

import java.util.Date;

public class TaskDto {
	private int id;
	private String name;
	private Date endDate;
	private String group_name;
	private String account_name;
	private String status_name;

	public TaskDto() {
		// TODO Auto-generated constructor stub
	}

	public TaskDto(int id, String name, Date endDate, String group_name, String account_name, String status_name) {

		this.id = id;
		this.name = name;
		this.endDate = endDate;
		this.group_name = group_name;
		this.account_name = account_name;
		this.status_name = status_name;
	}

	public TaskDto(String name, Date endDate, String group_name, String account_name, String status_name) {

		this.name = name;
		this.endDate = endDate;
		this.group_name = group_name;
		this.account_name = account_name;
		this.status_name = status_name;
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

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", name=" + name + ", endDate=" + endDate + ", group_name=" + group_name
				+ ", account_name=" + account_name + ", status_name=" + status_name + "]";
	}

}
