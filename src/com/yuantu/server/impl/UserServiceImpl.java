package com.yuantu.server.impl;

import java.sql.Connection;
import java.util.List;

import com.yuantu.dao.UserDao;
import com.yuantu.dao.impl.UserDaoImpl;
import com.yuantu.entity.User;
import com.yuantu.server.UserService;
import com.yuantu.web.filter.FirstFilter;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public Connection conn1;//正在使用的连接
	
	public UserServiceImpl() {
		super();
		//String dbDriver = "com.mysql.jdbc.Driver";
		//String dbUrl = "jdbc:mysql://127.0.0.1:3306/yuantu?useSSL=false";
		//String dbUser = "root";
		//String dbPassword = "123456";
		// super(dbUrl, dbUserName, dbPassword, dbDriver);
		this.userDao = new UserDaoImpl(FirstFilter.map);
	}
	
	@Override
	public int userLogin(String username, String pwd) {
		int result = userDao.queryByUser(username, pwd);
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return result;
	}

	@Override
	public int saveUser(User user) {
		int result = userDao.queryByName(user.getUserName());
		int result1=0;
		if(result==0) {
			result1=userDao.save(user);
		}
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return result1;
	}
	@Override
	public List<User> queryAll() {
		List<User> list = userDao.queryAll();
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return list;
	}

	@Override
	public List<User> queryByNames(String username, String name) {
		List<User> list = userDao.queryUsers(username, name);
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return list;
	}

	@Override
	public int deleteUserById(String id) {
		int result = userDao.deleteById(id);
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return result;
		
	}

	@Override
	public int updateUser(User user) {
		int result = userDao.update(user);
		this.conn1 = ((UserDaoImpl)userDao).getCon();
		System.out.println(conn1);
		return result;
	}

}
