package com.yuantu.web.servlet;

import java.io.IOException;

import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuantu.entity.User;

import com.yuantu.server.UserService;
import com.yuantu.server.impl.UserServiceImpl;
import com.yuantu.util.Md5Util;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("text/html; charset=UTF-8");

		String username =request.getParameter("username");
		String pwd1 =request.getParameter("pwd1");
		
		String name =request.getParameter("name");
		String gender =request.getParameter("gender");
		String age = request.getParameter("age");
		
		
		
		UserService userService = new UserServiceImpl();
		
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		User user = new User(id,username,Md5Util.encrypt(pwd1),name,gender,Integer.parseInt(age));
		int result = userService.saveUser(user);
		String message;
		if(result==0) {
			message = "�û����Ѵ���";
		}else {
			message = username+":ע��ɹ�";
		}
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/regShow.jsp");
		
		request.setAttribute("result", message);

		dispatcher.forward(request, response);
	}

}
