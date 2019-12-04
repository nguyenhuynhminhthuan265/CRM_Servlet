package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myclass.connection.JDBCConnection;
import com.myclass.dto.AccountDto;
import com.myclass.entity.Account;

public class LoginRepository {
	private final String FIND_BY_EMAIL = "select a.account_id, a.email,a.password,a.fullname,a.phone,a.address,r.name as role_name from accounts a join roles r on (a.role_id=r.id) where a.email= ?;";
	private final String ADD_NEW_ACCOUNT = "INSERT INTO accounts (email,password,fullname,phone,address,role_id) values (?,?,?,?,?,?);";

	public AccountDto FindByEmail(String email) {
		AccountDto account = new AccountDto();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_BY_EMAIL);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				account.setId(rs.getInt("account_id"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
				account.setPhone(rs.getString("phone"));
				account.setAddress(rs.getString("address"));
				account.setRoleName(rs.getString("role_name"));
			}
			return account;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public int AddNewAccount(Account account) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(ADD_NEW_ACCOUNT);
			stmt.setString(1, account.getEmail());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getFullName());
			stmt.setString(4, account.getPhone());
			stmt.setString(5, account.getAddress());
			stmt.setInt(6, account.getRole_id());
			result = stmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;

	}
}
