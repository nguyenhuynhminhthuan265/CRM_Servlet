package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@WebServlet(name = "RoleController", urlPatterns = { UrlConstants.ROLE_LIST, UrlConstants.ROLE_ADD,
		UrlConstants.ROLE_DELETE, UrlConstants.ROLE_EDIT })
public class RoleController extends HttpServlet {
	private RoleRepository roleRepository;

	public RoleController() {
		roleRepository = new RoleRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		System.out.println(action);

		switch (action) {
		case UrlConstants.ROLE_LIST:

			List<Role> roles = roleRepository.findAll();
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/views/role/index.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_ADD:
			req.getRequestDispatcher("/views/role/add.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_EDIT:
			int idEdit = Integer.parseInt(req.getParameter("id"));
			System.out.println("ID EDIT: " + idEdit);
			Role role = roleRepository.findById(idEdit);
			req.setAttribute("role", role);
			req.getRequestDispatcher("/views/role/edit.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			int result = roleRepository.delete(idDelete);
			if (result < 0) {
				req.setAttribute("message", "Xoa that bai");
				req.getRequestDispatcher("/views/role/index.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConstants.ROLE_LIST);
			}

			break;

		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		System.out.println(action);

		switch (action) {
		case UrlConstants.ROLE_ADD:
			Role role = new Role();
			role.setName(req.getParameter("name"));
			role.setDescription(req.getParameter("description"));
			int result = roleRepository.add(role);
			if (result < 0) {
				req.setAttribute("message", "That bai");
				req.getRequestDispatcher("/views/role/add.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConstants.ROLE_LIST);
			}

			break;
		case UrlConstants.ROLE_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("nameEdit");
			String description = req.getParameter("descriptionEdit");
			Role roleEdit = new Role(id, name, description);
			int res = roleRepository.edit(roleEdit);
			if (res < 0) {
				req.setAttribute("message", "That bai");
				req.getRequestDispatcher("/views/role/add.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConstants.ROLE_LIST);
			}
			break;

		default:
			break;
		}
	}

}
