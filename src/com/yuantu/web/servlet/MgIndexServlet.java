package com.yuantu.web.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MgIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MgIndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if ("admin".equals(username) && "admin".equals(pwd)) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mgIndex.jsp");
			// 请求转发
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
