package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Role;

public class RoleRepository {
	private final String FIND_ALL = "select *from roles";
	private final String FIND_BY_ID = "select *from roles where id = ?";
	private String ROLE_UPDATE = "UPDATE roles SET name= ?, description= ? WHERE id= ? ";

	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 1: Kết nối DB

			// Bước 2: Gửi câu truy vấn

			PreparedStatement stmt = conn.prepareStatement(FIND_ALL);
			// Bước 3: Xử lý kết quả trả về
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				roles.add(role);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

	public int add(Role role) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 1: Kết nối DB

			// Bước 2: Gửi câu truy vấn
			String sQuery = "INSERT INTO roles(name,description) VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sQuery);
			// Set du liệu cho câu truy vấn
			stmt.setString(1, role.getName());
			stmt.setString(2, role.getDescription());

			result = stmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Role findById(int ID) {
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				return role;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public int edit(Role role) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(ROLE_UPDATE);
			stmt.setString(1, role.getName());
			stmt.setString(2, role.getDescription());
			stmt.setInt(3, role.getId());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int delete(int id) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 1: Kết nối DB

			// Bước 2: Gửi câu truy vấn
			String sQuery = "DELETE FROM roles WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sQuery);
			// Set du liệu cho câu truy vấn

			stmt.setInt(1, id);

			result = stmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
