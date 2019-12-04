package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.myclass.connection.JDBCConnection;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;

public class TaskRepository extends GroupRepository {
	private final String ADD_NEW_TASK = "INSERT INTO tasks (task_name, end_date, account_id, group_id, status_id) VALUES (?,?,?,?,?);";
	private final String DELETE_TASK = "DELETE FROM tasks WHERE task_id=?;";
	private final String FIND_ALL_BY_ID_OF_TASK = "select t.task_id, t.task_name, t.end_date,g.group_name, a.fullname, s.status_name from tasks t, groupwork g, accounts a, status s where t.group_id=g.group_id and t.account_id=a.account_id and t.status_id=s.status_id and t.task_id=?; ;";
	private final String UPDATE_TASK = "UPDATE tasks SET task_name=?, end_date=?, account_id=?, status_id=? where task_id=?;";

	public int add(Task task) {
		int result = -1;
		SimpleDateFormat formatDatetoString = new SimpleDateFormat("yyyy/mm/dd");
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(ADD_NEW_TASK);
			stmt.setString(1, task.getName());
			stmt.setString(2, formatDatetoString.format(task.getEndDate()));
			stmt.setInt(3, task.getAccount_id());
			stmt.setInt(4, task.getGroup_id());
			stmt.setInt(5, task.getStatus_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public int delete(int idTaskDelete) {
		int result = -1;

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(DELETE_TASK);
			stmt.setInt(1, idTaskDelete);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public TaskDto FindAllById_Task(int idTask) {
		TaskDto taskDto = new TaskDto();
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(FIND_ALL_BY_ID_OF_TASK);
			stmt.setInt(1, idTask);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				taskDto.setId(rs.getInt("task_id"));
				taskDto.setName(rs.getString("task_name"));
				taskDto.setEndDate(rs.getDate("end_date"));
				taskDto.setGroup_name(rs.getString("group_name"));
				taskDto.setAccount_name(rs.getString("fullname"));
				taskDto.setStatus_name(rs.getString("status_name"));

			}
			return taskDto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public int edit(Task task) {
		int result = -1;
		SimpleDateFormat formatDatetoString = new SimpleDateFormat("yyyy/mm/dd");
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_TASK);
			stmt.setString(1, task.getName());
			stmt.setString(2, formatDatetoString.format(task.getEndDate()));
			stmt.setInt(3, task.getAccount_id());
			// stmt.setInt(4, task.getGroup_id());
			stmt.setInt(4, task.getStatus_id());
			stmt.setInt(5, task.getId());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}
}
