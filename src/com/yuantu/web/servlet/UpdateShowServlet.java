package com.yuantu.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuantu.entity.User;
import com.yuantu.server.UserService;
import com.yuantu.server.impl.UserServiceImpl;




public class UpdateShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		String uId = request.getParameter("id");
		String name = request.getParameter("name");
		
		String age = request.getParameter("age");
		
		request.setAttribute("uid", uId);
		request.setAttribute("name", name);
		
		request.setAttribute("age", age);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateShow.jsp");
		// ����ת��
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
				request.setCharacterEncoding("utf-8");
				// ��Ӧ����
				response.setContentType("text/html; charset=UTF-8");
				String id = request.getParameter("uid");
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				String age = request.getParameter("age");
				System.out.println(age);
				UserService userService = new UserServiceImpl();
				User user = new User();
				user.setuId(id);
				user.setName(name);
				user.setGender(gender);
				user.setAge(new Integer(age));
				int result = userService.updateUser(user);
				String message;
				if(result>0) {
					message ="�޸ĳɹ�";
				}else {
					message ="�޸�ʧ��";
				}
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/updateResult.jsp");
				
				request.setAttribute("result", message);

				dispatcher.forward(request, response);
			
	}

}
