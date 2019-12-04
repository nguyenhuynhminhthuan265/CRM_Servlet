package com.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Group;
import com.myclass.repository.GroupRepository;

@WebServlet(name = "GroupServlet", urlPatterns = { UrlConstants.GROUP_LIST, UrlConstants.GROUP_ADD,
		UrlConstants.GROUP_DELETE, UrlConstants.GROUP_EDIT, UrlConstants.GROUP_DETAILS })
public class GroupController extends HttpServlet {
	private GroupRepository groupRepository;

	public GroupController() {
		// TODO Auto-generated constructor stub
		groupRepository = new GroupRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case UrlConstants.GROUP_LIST:
			List<Group> groupworks = groupRepository.FindAll();
			req.setAttribute("groupworks", groupworks);
			req.getRequestDispatcher("/views/group/index.jsp").forward(req, resp);
			break;
		case UrlConstants.GROUP_ADD:
			req.getRequestDispatcher("/views/group/add.jsp").forward(req, resp);
			break;
		case UrlConstants.GROUP_EDIT:
			GetEdit(req, resp);
			break;
		case UrlConstants.GROUP_DELETE:
			GetDelete(req, resp);
			break;
		case UrlConstants.GROUP_DETAILS:
			GetDetails(req, resp);
			req.getRequestDispatcher("/views/group/details.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	}

	public void GetDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

	public void GetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDelete = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID DELETE: " + idDelete);
		int result = groupRepository.Delete(idDelete);

		if (result < 0) {
			req.setAttribute("message", "Lỗi");
			req.getRequestDispatcher("/views/group/index.jsp").forward(req, resp);

		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);

		}
	}

	public void GetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idEdit = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID EDIT: " + idEdit);
		Group group = groupRepository.FindById(idEdit);
		req.setAttribute("group", group);
		req.getRequestDispatcher("/views/group/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);

		switch (action) {
		case UrlConstants.GROUP_ADD:

			PostAdd(req, resp);
			break;
		case UrlConstants.GROUP_EDIT:
			PostEdit(req, resp);
			break;
		default:
			break;
		}
	}

	public void PostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idEdit = Integer.parseInt(req.getParameter("id"));
		String groupName = req.getParameter("groupName");
		String groupDescription = req.getParameter("groupDescription");
		Group group = new Group(idEdit, groupName, groupDescription);
		int result = groupRepository.Edit(group);
		if (result < 0) {
			req.setAttribute("message", "Lỗi");
			req.getRequestDispatcher("/views/group/edit.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);

		}
	}

	public void PostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String groupName = req.getParameter("groupName");

		String groupDescription = req.getParameter("groupDescription");

		Group group = new Group(groupName, groupDescription);
		int result = groupRepository.Add(group);
		if (result < 0) {
			req.setAttribute("message", "Lỗi");
			req.getRequestDispatcher("/views/group/add.jsp").forward(req, resp);

		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.GROUP_LIST);

		}
	}
}
