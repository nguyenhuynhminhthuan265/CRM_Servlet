package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.dto.AccountDto;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Account;

public class AccountRepository {
	private final String FIND_ALL = "select a.account_id, a.email,a.password,a.fullname,a.phone,a.address,r.name as role_name from accounts a join roles r on (a.role_id=r.id) ;";

	private final String ADD_NEW_ACCOUNT = "INSERT INTO accounts (email,password,fullname,phone,address,role_id) values (?,?,?,?,?,?);";

	private final String FIND_BY_ID = "select a.account_id, a.email,a.password,a.fullname,a.phone,a.address,r.name as role_name from accounts a join roles r on (a.role_id=r.id) where account_id=?";

	private final String UPDATE_ACCOUNT = "UPDATE accounts SET email=?, password=?, fullname=?, phone=?, address=?, role_id=? WHERE account_id=? ";

	private final String DELETE_ACCOUNT_BY_ID = "DELETE FROM accounts WHERE account_id=?";

	private final String FIND_LIST_GROUPWORK = "select t.task_id, t.task_name, t.end_date,g.group_name, a.fullname, s.status_name from tasks t, groupwork g, accounts a, status s where t.group_id=g.group_id and t.account_id=a.account_id and t.status_id=s.status_id and a.account_id=?; ";

	private final String FIND_STATUS_NAME = "select distinct status_name from status;";

	public List<AccountDto> FindAll() {
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AccountDto account = new AccountDto();
				account.setId(rs.getInt("account_id"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
				account.setPhone(rs.getString("phone"));
				account.setAddress(rs.getString("address"));
				account.setRoleName(rs.getString("role_name"));

				accounts.add(account);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return accounts;

	}

	public int Add(Account account) {
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

	public AccountDto FindById(int ID) {
		AccountDto account = new AccountDto();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("account_id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String fullName = rs.getString("fullname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String roleName = rs.getString("role_name");

				account = new AccountDto(id, fullName, email, password, phone, address, roleName);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return account;
	}

	public int Edit(Account account) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_ACCOUNT);
			stmt.setString(1, account.getEmail());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getFullName());
			stmt.setString(4, account.getPhone());
			stmt.setString(5, account.getAddress());
			stmt.setInt(6, account.getRole_id());
			stmt.setInt(7, account.getId());

			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public int Delete(int idDelete) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(DELETE_ACCOUNT_BY_ID);
			stmt.setInt(1, idDelete);
			result = stmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public List<TaskDto> GetListGroupWork(int account_id) {
		List<TaskDto> list = new ArrayList<TaskDto>();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_LIST_GROUPWORK);
			stmt.setInt(1, account_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TaskDto taskDto = new TaskDto();
				taskDto.setId(rs.getInt("task_id"));
				taskDto.setName(rs.getString("task_name"));
				taskDto.setEndDate(rs.getDate("end_date"));
				taskDto.setGroup_name(rs.getString("group_name"));
				taskDto.setAccount_name(rs.getString("fullname"));
				taskDto.setStatus_name(rs.getString("status_name"));
				list.add(taskDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<String> GetListStatusName() {
		ArrayList<String> statusNames = new ArrayList<String>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_STATUS_NAME);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				statusNames.add(rs.getString("status_name"));
			}
			return statusNames;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return statusNames;
	}

}
