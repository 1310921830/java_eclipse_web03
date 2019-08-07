package com.yuantu.server;

import java.util.List;

import com.yuantu.entity.User;

public interface UserService {
	//�û���¼
	int userLogin(String username,String pwd);
	//�û�ע��
	int saveUser(User user);
	//չʾ�����û�
	List<User> queryAll();
	//ͨ���û���������ģ����ѯ
	List<User> queryByNames(String username,String name);
	
	//����idɾ���û�
	int deleteUserById(String id);
	
	//�����û�����
	int updateUser(User user);
}
