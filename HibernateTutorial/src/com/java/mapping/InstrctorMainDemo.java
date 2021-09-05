package com.java.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstrctorMainDemo {
	static Session session = null;
	static SessionFactory sessionFactory = null;
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		Instructor instructor = new Instructor("Vihaan", "Bankar", "vihaan@gmail.com");
		InstructorDetail detail=new InstructorDetail("java youtube", "code practise");
		instructor.setInstructorDetail(detail);
		session.beginTransaction();
		int s=(int) session.save(instructor);
		System.out.println("Inserted value:"+s);
		session.getTransaction().commit();
		
	}
}
