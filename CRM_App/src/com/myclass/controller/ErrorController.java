package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ErrorServlet", urlPatterns = { "/404", "/error" })
public class ErrorController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/404":
			req.getRequestDispatcher("/views/404/index.jsp").forward(req, resp);
			break;
		case "/error":
			req.getRequestDispatcher("/views/404/index.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
}
