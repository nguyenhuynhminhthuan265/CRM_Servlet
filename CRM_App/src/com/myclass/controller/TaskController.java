package com.myclass.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.AccountDto;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Status;
import com.myclass.entity.Task;
import com.myclass.repository.AccountRepository;
import com.myclass.repository.GroupRepository;
import com.myclass.repository.StatusRepository;
import com.myclass.repository.TaskRepository;

@WebServlet(name = "TaskServlet", urlPatterns = { UrlConstants.TASK_LIST, UrlConstants.TASK_ADD,
		UrlConstants.TASK_DELETE, UrlConstants.TASK_EDIT, UrlConstants.TASK_DETAILS })
public class TaskController extends HttpServlet {
	private final TaskRepository taskRepository;
	private final GroupRepository groupRepository;
	private final AccountRepository accountRepository;
	private final StatusRepository statusRepository;

	public TaskController() {
		taskRepository = new TaskRepository();
		groupRepository = new GroupRepository();
		accountRepository = new AccountRepository();
		statusRepository = new StatusRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		List<AccountDto> accounts = accountRepository.FindAll();
		List<Status> statusNames = statusRepository.FindAll();
		switch (action) {
		case UrlConstants.TASK_LIST:
			doGet_TaskList(req, resp, accounts, statusNames);
			break;
		case UrlConstants.TASK_ADD:

			break;
		case UrlConstants.TASK_DELETE:
			doGet_Delete(req, resp);
			break;
		case UrlConstants.TASK_EDIT:
			doGet_Edit(req, resp, accounts, statusNames);
			break;

		default:
			break;
		}
	}

	private void doGet_Edit(HttpServletRequest req, HttpServletResponse resp, List<AccountDto> accounts,
			List<Status> statusNames) throws ServletException, IOException {
		int idTaskEdit = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID TASK EDIT: " + idTaskEdit);
		TaskDto taskDto = taskRepository.FindAllById_Task(idTaskEdit);
		req.setAttribute("accounts", accounts);
		req.setAttribute("taskEdit", taskDto);
		req.setAttribute("statusNames", statusNames);
		req.getRequestDispatcher("/views/task/edit.jsp").forward(req, resp);
	}

	private void doGet_Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idTaskDelete = Integer.parseInt(req.getParameter("id"));
		System.out.println("Task_Id Delete: " + idTaskDelete);
		int result = taskRepository.delete(idTaskDelete);
		if (result < 0) {
			req.setAttribute("message", "Them that bai !!!");
			req.getRequestDispatcher("/views/task/index.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);
		}
	}

	private void doGet_TaskList(HttpServletRequest req, HttpServletResponse resp, List<AccountDto> accounts,
			List<Status> statusNames) throws ServletException, IOException {
		int idGroupwork = Integer.parseInt(req.getParameter("id"));
		// System.out.println("ID Group: " + idGroup);
		req.setAttribute("accounts", accounts);
		req.setAttribute("statusNames", statusNames);
		req.setAttribute("idGroup", idGroupwork);
		doGet_TaskList(req, resp);
		req.getRequestDispatcher("/views/task/index.jsp").forward(req, resp);
	}

	public void doGet_TaskList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDetails = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID Details: " + idDetails);
		ArrayList<String> statusNames = groupRepository.GetListStatusName();
		String statusName_notDone = statusNames.get(0);
		String statusName_Doing = statusNames.get(1);
		String statusName_Done = statusNames.get(2);
		List<TaskDto> listAccountOfGroup = groupRepository.FindAllByGroupID(idDetails);
		req.setAttribute("statusName_notDone", statusName_notDone);
		req.setAttribute("statusName_Doing", statusName_Doing);
		req.setAttribute("statusName_Done", statusName_Done);
		req.setAttribute("listAccountOfGroup", listAccountOfGroup);
		if (listAccountOfGroup.size() == 0 || listAccountOfGroup == null || listAccountOfGroup.isEmpty()) {
			req.setAttribute("groupName", "");
		} else {
			req.setAttribute("groupName", listAccountOfGroup.get(0).getGroup_name());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {

		case UrlConstants.TASK_ADD:

			PostAdd(req, resp);

			break;

		case UrlConstants.TASK_EDIT:
			PostEdit(req, resp);
			break;

		default:
			break;
		}
	}

	private void PostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idTask = Integer.parseInt(req.getParameter("idTask"));
			// int idGroup = Integer.parseInt(req.getParameter("idGroup"));
			String taskName = req.getParameter("taskName");
			String endDate = req.getParameter("endDate");
			String accountID = req.getParameter("accountName");
			String status = req.getParameter("status");
			System.out.println(endDate);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat formatDatetoString = new SimpleDateFormat("yyyy-mm-dd");
			Task task = new Task(idTask, taskName, format.parse(endDate), Integer.parseInt(accountID),
					Integer.parseInt(status));
			System.out.println(task.toString());
			System.out.println(formatDatetoString.format(task.getEndDate()));
			int result = taskRepository.edit(task);
			if (result < 0) {
				req.setAttribute("message", "Cập nhật that bai !!!");
				req.getRequestDispatcher("/views/task/edit.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);
			}
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void PostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idGroup = Integer.parseInt(req.getParameter("idGroup"));
			String taskName = req.getParameter("taskName");
			String endDate = req.getParameter("endDate");
			String accountID = req.getParameter("accountName");
			String status = req.getParameter("status");
			System.out.println(endDate);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat formatDatetoString = new SimpleDateFormat("yyyy-mm-dd");
			Task task = new Task(taskName, format.parse(endDate), idGroup, Integer.parseInt(accountID),
					Integer.parseInt(status));
			System.out.println(task.toString());
			System.out.println(formatDatetoString.format(task.getEndDate()));
			int result = taskRepository.add(task);
			if (result < 0) {
				req.setAttribute("message", "Them that bai !!!");
				req.getRequestDispatcher("/views/task/index.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);
			}
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
