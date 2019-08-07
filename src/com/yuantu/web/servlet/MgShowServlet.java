package com.yuantu.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuantu.entity.User;
import com.yuantu.server.UserService;
import com.yuantu.server.impl.UserServiceImpl;
import com.yuantu.web.filter.FirstFilter;


public class MgShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection cc; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");

		UserService userService = new UserServiceImpl();
		
		List<User> list = userService.queryAll();
		this.cc = ((UserServiceImpl)userService).conn1;
		FirstFilter.map.put(this.cc, 1);
		System.out.println(FirstFilter.map);	
		request.setAttribute("userList", list);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mgShow.jsp");
		//请求转发
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		UserService userService = new UserServiceImpl();
		
		List<User> list = userService.queryByNames(username, name);
		this.cc = ((UserServiceImpl)userService).conn1;
		FirstFilter.map.put(this.cc, 1);
		System.out.println(FirstFilter.map);
		request.setAttribute("userList", list);
		request.setAttribute("uname", username);
		request.setAttribute("name", name);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mgShow.jsp");
		//请求转发
		dispatcher.forward(request, response);
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		FirstFilter.map.put(this.cc, 0);
	}


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}
	
}
