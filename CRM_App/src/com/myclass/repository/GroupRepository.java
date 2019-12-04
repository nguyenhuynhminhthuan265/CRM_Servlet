package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Group;

public class GroupRepository {
	private static final String GROUP_FIND_ALL = "select *from groupwork;";
	private static final String GROUP_ADD = "INSERT INTO groupwork (group_name, description) VALUES(?,?) ";
	private static final String GROUP_FIND_BY_ID = "SELECT *FROM groupwork WHERE group_id=?;";
	private static final String GROUP_EDIT = "UPDATE groupwork SET group_name= ? , description= ? WHERE group_id= ?";
	private static final String GROUP_DELETE_BY_ID = "DELETE FROM groupwork WHERE group_id= ?";
	private static final String GROUP_FIND_ALL_BY_ID_OF_GROUP = "select t.task_id, t.task_name, t.end_date,g.group_name, a.fullname, s.status_name from tasks t, groupwork g, accounts a, status s where t.group_id=g.group_id and t.account_id=a.account_id and t.status_id=s.status_id and t.group_id=? ;";
	private static final String GROUP_FIND_STATUS_NAME = "select distinct status_name from status;";

	public List<Group> FindAll() {
		List<Group> groupworks = new ArrayList<Group>();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_FIND_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Group groupwork = new Group();
				groupwork.setId(rs.getInt("group_id"));
				groupwork.setGroupName(rs.getString("group_name"));
				groupwork.setGroupDescription(rs.getString("description"));
				groupworks.add(groupwork);
			}
			return groupworks;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return groupworks;
	}

	public int Add(Group group) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_ADD);
			stmt.setString(1, group.getGroupName());
			stmt.setString(2, group.getGroupDescription());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public Group FindById(int id) {
		Group group = new Group();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_FIND_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				group.setId(rs.getInt("group_id"));
				group.setGroupName(rs.getString("group_name"));
				group.setGroupDescription(rs.getString("description"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return group;
	}

	public int Edit(Group group) {
		int result = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_EDIT);
			stmt.setString(1, group.getGroupName());
			stmt.setString(2, group.getGroupDescription());
			stmt.setInt(3, group.getId());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int Delete(int id) {
		int rs = -1;
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_DELETE_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public List<TaskDto> FindAllByGroupID(int group_id) {
		List<TaskDto> list = new ArrayList<TaskDto>();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_FIND_ALL_BY_ID_OF_GROUP);
			stmt.setInt(1, group_id);
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
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public ArrayList<String> GetListStatusName() {
		ArrayList<String> statusNames = new ArrayList<String>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(GROUP_FIND_STATUS_NAME);
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
