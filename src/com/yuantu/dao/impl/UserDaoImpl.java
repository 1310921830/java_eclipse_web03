package com.yuantu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yuantu.dao.UserDao;
import com.yuantu.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	

	public UserDaoImpl(Map<Connection, Integer> m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int save(User t) {
		int result=0;
		String sql = "insert into yuantu_users(id,username,password,name,gender,age) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, t.getuId());
			pst.setString(2, t.getUserName());
			pst.setString(3, t.getPwd());
			pst.setString(4, t.getName());
			pst.setString(5, t.getGender());
			pst.setInt(6, t.getAge());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int deleteById(String id) {
		int result=0;
		String sql = "delete from yuantu_users where id=?";
		
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, id);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	@Override
	public int update(User t) {
		int result=0;
		String sql = "update yuantu_users set"+
				" name=?,gender=?,age=?"
				+ " where id=?";
		PreparedStatement pst = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(4, t.getuId());
			pst.setString(1, t.getName());
			pst.setString(2, t.getGender());
			pst.setInt(3, t.getAge());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	//根据id查询用户
	@Override
	//根据id查询用户
	public User queryById(String id) {
		User user = null;
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from yuantu_users"
				+ " where id=?";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, id);
			resultSet = pst.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getString(1),resultSet.getString(2), 
					resultSet.getString(3), resultSet.getString(4), 
					resultSet.getString(5), resultSet.getInt(6)
			);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	
	//展示所有用户信息
	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from yuantu_users";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		System.out.println(sql);
		
		try {
			pst = getCon().prepareStatement(sql);
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getString(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getInt(6)
						);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//登录验证
	public int queryByUser(String username,String pwd) {
		String sql = "select * from yuantu_users" + " where username=? and password=?";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			pst = getCon().prepareStatement(sql);
		pst.setString(1, username);
			pst.setString(2, pwd);
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				result= 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//根据用户名查询，用于判断注册时用户名是否已存在
	public int queryByName(String uname) {
		String sql = "select * from yuantu_users" + " where username=?";
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, uname);
			
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				result= 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//根据用户名和真实姓名，模糊查询
	public List<User> queryUsers(String username,String name) {
		List<User> list = new ArrayList<User>();
		String sql = "select id,"
				+ " username,"
				+ " password,"
				+ " name,"
				+ " gender,"
				+ " age"
				+ " from yuantu_users"
				+ " where 1=1";
		if(null!=username&&!"".equals(username)) {
			sql = sql+" and username like '%"+
					username.trim()+"%'";
		}
		if(null!=name&&!"".equals(name)) {
			sql = sql+" and name like '%"+
					name.trim()+"%'";
		}
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getString(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getInt(6)
						);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
