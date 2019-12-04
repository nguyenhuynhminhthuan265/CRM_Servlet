package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		HttpSession session = req.getSession();
		if (action.equals("/logout")) {
			if (session != null && session.getAttribute("ACCOUNT_LOGIN") != null) {
				session.removeAttribute("ACCOUNT_LOGIN");
				resp.sendRedirect(req.getContextPath() + "/login");
			}

		}

	}

}
