package com.yuantu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yuantu.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	//private String url;
	// 连接类型
	//private String driver;
	//private String user;
	//private String pwd;
	private Connection conn;
	
	public BaseDaoImpl(Map<Connection, Integer> m) {
		super();
		//this.url = url;
		//this.driver = driver;
		//this.user = user;
		//this.pwd = pwd;
		try {
			//Class.forName(driver); // MYSQL驱动
			Set<Connection> set = m.keySet();
			for(Connection c:set) {
				if(m.get(c)==0) {
					conn = c;
				}
			}
			if(conn==null) {
			conn = DriverManager.getConnection(url, 
					user,pwd);
			}// 链接本地MYSQL
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	

	public Connection getCon() {
		return conn;
	}

	public void closeConnection() throws Exception{
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public int save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(T t) {
		return 0;
		
	}
	@Override
	public T queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
