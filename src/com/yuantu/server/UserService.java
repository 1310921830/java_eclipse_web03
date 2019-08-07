package com.yuantu.server;

import java.util.List;

import com.yuantu.entity.User;

public interface UserService {
	//用户登录
	int userLogin(String username,String pwd);
	//用户注册
	int saveUser(User user);
	//展示所有用户
	List<User> queryAll();
	//通过用户名和姓名模糊查询
	List<User> queryByNames(String username,String name);
	
	//根据id删除用户
	int deleteUserById(String id);
	
	//根据用户更新
	int updateUser(User user);
}
