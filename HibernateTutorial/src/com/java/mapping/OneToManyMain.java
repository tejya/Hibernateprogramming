package com.java.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMain {
	static Session session = null;
	static SessionFactory sessionFactory = null;
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		Instructor instructor =session.get(Instructor.class, 2);
		Course c=new Course("Java 8 Funtional programing");
		Course c1=new Course("Docker container for beginner");
		instructor.add(c);
		instructor.add(c1);
		session.beginTransaction();
		//int s=(int) session.save(instructor);
		session.save(c1);
		session.save(c);
		session.getTransaction().commit();
	}

}
