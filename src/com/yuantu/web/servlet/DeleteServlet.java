package com.yuantu.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuantu.server.UserService;
import com.yuantu.server.impl.UserServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		String uId =request.getParameter("id");
		System.out.println(uId);
		UserService userService = new UserServiceImpl();
		userService.deleteUserById(uId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MgShow");
		// ����ת��
		dispatcher.forward(request, response);
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
