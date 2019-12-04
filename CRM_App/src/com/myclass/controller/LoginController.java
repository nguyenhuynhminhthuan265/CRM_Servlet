package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.AccountDto;
import com.myclass.entity.Account;
import com.myclass.entity.Role;
import com.myclass.repository.LoginRepository;
import com.myclass.repository.RoleRepository;

@WebServlet(name = "LoginServlet", urlPatterns = { UrlConstants.LOGIN, UrlConstants.REGISTER })
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginRepository loginRepository = null;
	RoleRepository roleRepository = null;

	public LoginController() {
		loginRepository = new LoginRepository();
		roleRepository = new RoleRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		// System.out.println(action);
		String error = req.getParameter("error");
		HttpSession session = req.getSession();
		List<Role> roles = roleRepository.findAll();
		req.setAttribute("roles", roles);
		session.setAttribute("roleOfRegister", roles);
		if (error != null && !error.isEmpty()) {
			req.setAttribute("message", "Vui long dang nhap");

		}
		req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case UrlConstants.LOGIN:
			PostLogin(req, resp);

			break;
		case UrlConstants.REGISTER:
			PostRegister(req, resp);

			break;
		default:
			break;
		}
	}

	private void PostRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String emailRegister = req.getParameter("email");
		String passwordRegister = req.getParameter("password");
		String fullNameRegister = req.getParameter("fullName");
		String phoneRegister = req.getParameter("phone");
		String addressRegister = req.getParameter("address");
		int role_idRegister = Integer.parseInt(req.getParameter("roleId"));
		Account accountRegister = new Account(fullNameRegister, emailRegister, passwordRegister, phoneRegister,
				addressRegister, role_idRegister);
		int result = loginRepository.AddNewAccount(accountRegister);
		if (result < -1) {
			req.setAttribute("message", "Đăng ký thất bại");
			req.getRequestDispatcher("/views/login/index.jsp");
			return;
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	private void PostLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		AccountDto account = loginRepository.FindByEmail(email);
		if (account == null || account.getEmail() == null || account.getPassword() == null) {
			req.setAttribute("message", "Account not in database !!!");
			req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
			return;
		}

		if (!password.equals(account.getPassword())) {
			req.setAttribute("message", "Password wrong !!!");
			req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
			return;
		}
		if (!email.equals(account.getEmail()) || !password.equals(account.getPassword())) {
			req.setAttribute("message", "Account not in database !!!");
			req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
			return;
		}
		HttpSession session = req.getSession(); // khởi tạo session
		session.setAttribute("ACCOUNT_LOGIN", account);
		session.setMaxInactiveInterval(60);
		resp.sendRedirect(req.getContextPath() + "/home");
	}

}
