package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dto.AccountDto;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String action = req.getServletPath();

		System.out.println("Action in Filter: " + action);

		// Trường hợp muốn client vào trang login thì chuyển req đến trang login
		if (action.equals("/login") || action.startsWith("/error") || action.equals("/register")) {
			chain.doFilter(request, response);
			return;
		}
		// Trường hợp client muốn vào các trang khác mà chưa đăng nhập thì filter chuyển
		// hướng req của client sang trang login kèm theo message "Yêu cầu đăng nhập"
		if (session.getAttribute("ACCOUNT_LOGIN") == null) {
			resp.sendRedirect(req.getContextPath() + "/login?error=123");
			return;
		}

		// PHÂN QUYỀN
		/*
		 * ROLE_ADMIN: ĐƯỢC VÀO TẤT CẢ CÁC TRANG.
		 */
		if (action.startsWith("/admin")) {
			AccountDto accountDto = (AccountDto) session.getAttribute("ACCOUNT_LOGIN");
			if (accountDto.getRoleName().equals("ROLE_ADMIN")) {
				chain.doFilter(request, response);
				return;
			} else {
				resp.sendRedirect(req.getContextPath() + "/404");
				return;
			}
			/*
			 * ROLE_MANAGER: KHÔNG ĐƯỢC VÀO ACCOUNT
			 */
		} else if (action.startsWith("/manager")) {
			AccountDto accountDto = (AccountDto) session.getAttribute("ACCOUNT_LOGIN");
			if (accountDto.getRoleName().equals("ROLE_ADMIN") || accountDto.getRoleName().equals("ROLE_MANAGER")) {
				chain.doFilter(request, response);
				return;
			} else {
				resp.sendRedirect(req.getContextPath() + "/404");
				return;
			}
		} else {
			// Trường hợp client đã đăng nhập mà không có quyền admin và manager chỉ được
			// vào trang home
			chain.doFilter(request, response);
			return;
		}

	}

}
