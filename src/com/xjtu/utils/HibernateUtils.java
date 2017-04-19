package com.xjtu.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
private static SessionFactory sf;
	
	static{
		//1加载配置
		Configuration  conf = new Configuration().configure();
		//2 根据Configuration 配置信息创建 SessionFactory
		sf = conf.buildSessionFactory();
	}
	
	
	public static org.hibernate.Session  openSession(){
				
				//3 获得session
				Session session = sf.openSession();
				
				return session;
	}
	
	public static org.hibernate.Session  getCurrentSession(){
		//3 获得session
		Session session = sf.getCurrentSession();
		
		return session;
}
	public static void main(String[] args) {
		getCurrentSession();
	}
}
