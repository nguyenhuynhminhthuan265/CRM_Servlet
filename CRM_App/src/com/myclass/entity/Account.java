package com.myclass.entity;

public class Account {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String phone;
	private String address;
	private int role_id;

	public Account(int id, String fullName, String email, String password, String phone, String address, int role_id) {

		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
	}

	public Account(String fullName, String email, String password, String phone, String address, int role_id) {

		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String fullName, String email, String password, String phone, String address) {

		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Account(String fullName, String email, String password, String phone, String address) {

		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", role_id=" + role_id + "]";
	}

}
