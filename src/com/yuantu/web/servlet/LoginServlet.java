package com.yuantu.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuantu.server.UserService;
import com.yuantu.server.impl.UserServiceImpl;
import com.yuantu.util.Md5Util;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		UserService userService = new UserServiceImpl();
		int result = userService.userLogin(username, Md5Util.encrypt(pwd));
		String message;
		if(result==1) {
			message = username+">>��¼�ɹ�";
		}else {
			message = "�û������������";
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/loginShow.jsp");
		
		request.setAttribute("result", message);
		//����ת��
		dispatcher.forward(request, response);
	}

}
