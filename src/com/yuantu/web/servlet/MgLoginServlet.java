package com.yuantu.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MgLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MgLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mgLogin.jsp");
		//����ת��
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
