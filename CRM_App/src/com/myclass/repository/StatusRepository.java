package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Status;

public class StatusRepository {
	private final String FIND_ALL = "select *from status; ";

	public List<Status> FindAll() {
		try (Connection conn = JDBCConnection.getConnection()) {
			List<Status> status = new ArrayList<Status>();
			PreparedStatement stmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Status temp = new Status();
				temp.setId(rs.getInt("status_id"));
				temp.setName(rs.getString("status_name"));
				status.add(temp);
			}
			return status;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
