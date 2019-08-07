package com.yuantu.web.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.yuantu.dao.BaseDao;


@WebFilter("/FirstFilter")
public class FirstFilter implements Filter {
	public static Map<Connection, Integer> map = new HashMap<Connection, Integer>();
    /**
     * Default constructor. 
     */
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		Set<Connection> set = map.keySet();
		for(Connection c:set) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("filter is working!");
		
		System.out.println(request.getRemoteAddr());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 try {
			Class.forName(BaseDao.driver); // MYSQL驱动
			Connection conn1 = DriverManager.getConnection(BaseDao.url, 
					BaseDao.user,BaseDao.pwd);
			Connection conn2 = DriverManager.getConnection(BaseDao.url, 
					BaseDao.user,BaseDao.pwd);
			Connection conn3 = DriverManager.getConnection(BaseDao.url, 
					BaseDao.user,BaseDao.pwd);
			Connection conn4 = DriverManager.getConnection(BaseDao.url, 
					BaseDao.user,BaseDao.pwd);
			Connection conn5 = DriverManager.getConnection(BaseDao.url, 
					BaseDao.user,BaseDao.pwd);
			System.out.println(conn1);
			System.out.println(conn2);
			System.out.println(conn3);
			System.out.println(conn4);
			System.out.println(conn5);
			map.put(conn1, 0);
			map.put(conn2, 0);
			map.put(conn3, 0);
			map.put(conn4, 0);
			map.put(conn5, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("连接初始化");
	}

}
