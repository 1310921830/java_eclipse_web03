package com.yuantu.dao;

import java.util.List;

public interface BaseDao<T> {
	String url="jdbc:mysql://127.0.0.1:3306/yuantu?useSSL=false";
	// ��������
	String driver="com.mysql.jdbc.Driver";
	String user="root";
	String pwd="123456";
	//����ʵ��
	public int save(T t);
	
	//ɾ��ʵ��
	int delete(T t);
	
	int deleteById(String id);
	//����ʵ��
	int update(T t);
	
	//����id��ѯ
	public T queryById(String id);
	
	//��ѯ����
	public List<T> queryAll();

	
}
