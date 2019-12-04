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
import com.myclass.dto.AccountDto;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Account;
import com.myclass.repository.AccountRepository;
import com.myclass.repository.RoleRepository;

@WebServlet(name = "AccountServlet", urlPatterns = { UrlConstants.ACCOUNT_LIST, UrlConstants.ACCOUNT_ADD,
		UrlConstants.ACCOUNT_DELETE, UrlConstants.ACCOUNT_EDIT, UrlConstants.ACCOUNT_DETAILS })
public class AccountController extends HttpServlet {
	private AccountRepository accountRepository = null;
	private RoleRepository roleRepository = null;

	public AccountController() {
		accountRepository = new AccountRepository();
		roleRepository = new RoleRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		System.out.println(action);
		switch (action) {
		case UrlConstants.ACCOUNT_LIST:
			List<AccountDto> accounts = accountRepository.FindAll();
			req.setAttribute("accounts", accounts);
			req.getRequestDispatcher("/views/account/index.jsp").forward(req, resp);
			break;
		case UrlConstants.ACCOUNT_ADD:
			req.setAttribute("roles", roleRepository.findAll());
			req.getRequestDispatcher("/views/account/add.jsp").forward(req, resp);
			break;
		case UrlConstants.ACCOUNT_EDIT:
			doGet_Edit(req, resp);
			break;
		case UrlConstants.ACCOUNT_DELETE:
			doGet_Delete(req, resp);
			break;
		case UrlConstants.ACCOUNT_DETAILS:
			doGet_Details(req, resp);
			break;

		default:
			break;
		}
	}

	private void doGet_Details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDetails = Integer.parseInt(req.getParameter("id"));
		System.out.println("idDetails: " + idDetails);
		AccountDto account = accountRepository.FindById(idDetails);

		List<TaskDto> listGroupWorkOfAccount = accountRepository.GetListGroupWork(idDetails);
		ArrayList<String> statusNames = accountRepository.GetListStatusName();
		String statusName_notDone = statusNames.get(0);
		String statusName_Doing = statusNames.get(1);
		String statusName_Done = statusNames.get(2);
		req.setAttribute("statusName_notDone", statusName_notDone);
		req.setAttribute("statusName_Doing", statusName_Doing);
		req.setAttribute("statusName_Done", statusName_Done);
		req.setAttribute("listGroupWorkOfAccount", listGroupWorkOfAccount);

		req.setAttribute("account", account);
		req.getRequestDispatcher("/views/account/details.jsp").forward(req, resp);
	}

	private void doGet_Edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idEdit = Integer.parseInt(req.getParameter("id"));
		System.out.println("idEdit: " + idEdit);
		AccountDto account = accountRepository.FindById(idEdit);
		System.out.println(account.toString());
		req.setAttribute("account", account);
		req.setAttribute("roles", roleRepository.findAll());
		req.getRequestDispatcher("/views/account/edit.jsp").forward(req, resp);
	}

	private void doGet_Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDelete = Integer.parseInt(req.getParameter("id"));
		System.out.println("idDelete: " + idDelete);
		int result = accountRepository.Delete(idDelete);
		if (result < 0) {
			req.setAttribute("message", "Xóa không thành công !!!");
			req.getRequestDispatcher("/views/account/index.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.ACCOUNT_LIST);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case UrlConstants.ACCOUNT_ADD:
			PostAdd(req, resp);

			break;
		case UrlConstants.ACCOUNT_EDIT:
			PostEdit(req, resp);
			break;
		default:
			break;
		}

	}

	private void PostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		String roleId = req.getParameter("roleId");

		Account account = new Account(id, fullName, email, password, phone, address, Integer.parseInt(roleId));
		System.out.println(account.toString());
		int result = accountRepository.Edit(account);
		if (result < 0) {
			req.setAttribute("message", "Cập nhật không thành công !!!");
			req.getRequestDispatcher("/views/account/edit.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.ACCOUNT_LIST);
		}
	}

	private void PostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		// req.getParameter("roleId") sẽ lấy giá trị trong value
		String roleId = req.getParameter("roleId");

		Account account = new Account(fullName, email, password, phone, address, Integer.parseInt(roleId));
		System.out.println(account.toString());

		int result = accountRepository.Add(account);
		if (result < 0) {
			req.setAttribute("message", "Thêm mới không thành công !!!");
			req.getRequestDispatcher("/views/account/add.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConstants.ACCOUNT_LIST);
		}
	}
}
