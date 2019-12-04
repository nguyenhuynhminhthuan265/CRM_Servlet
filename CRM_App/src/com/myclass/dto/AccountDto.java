package com.myclass.dto;

public class AccountDto {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String phone;
	private String address;
	private String roleName;

	public AccountDto() {
		// TODO Auto-generated constructor stub
	}

	public AccountDto(int id, String fullName, String email, String password, String phone, String address,
			String roleName) {

		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.roleName = roleName;
	}

	public AccountDto(String fullName, String email, String password, String phone, String address, String roleName) {

		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.roleName = roleName;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", roleName=" + roleName + "]";
	}

}
