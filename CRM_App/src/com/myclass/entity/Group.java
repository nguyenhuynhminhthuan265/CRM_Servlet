package com.myclass.entity;

public class Group {
	private int id;
	private String groupName;
	private String groupDescription;

	public Group() {
		// TODO Auto-generated constructor stub
	}

	public Group(int id, String groupName, String groupDescription) {

		this.id = id;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
	}

	public Group(String groupName, String groupDescription) {

		this.groupName = groupName;
		this.groupDescription = groupDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

}
