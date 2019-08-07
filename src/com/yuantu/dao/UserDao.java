package com.yuantu.dao;



import java.util.List;

import com.yuantu.entity.User;

public interface UserDao extends BaseDao<User>{
	
	//��¼��֤
	public int queryByUser(String username,String pwd);
	
	//�����û�����ѯ�������ж�ע��ʱ�û����Ƿ��Ѵ���
	public int queryByName(String uname);
	
	//�����û�������ʵ������ģ����ѯ
	public List<User> queryUsers(String username,String name);
}
