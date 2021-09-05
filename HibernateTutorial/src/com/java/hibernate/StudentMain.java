package com.java.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {
	static Session session = null;
	static SessionFactory sessionFactory = null;
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class)
				.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			addStudent();
			getStudent();
			displayStudent();
			displayByLikeQuery();
			updateStudent();
			//deleteStudent();
		} finally {
			sessionFactory.close();
		}

	}

	public static void addStudent() {
		session.beginTransaction();
		StudentEntity s = new StudentEntity();
		s.setId(2);
		s.setFname("tommy");
		s.setLname("bnkar");
		s.setEmail("t@gmil.com");
		session.save(s);
		session.getTransaction().commit();
		//session.close();
	}

	public static void getStudent() {
		session.beginTransaction();
		StudentEntity stud = session.load(StudentEntity.class, 1);
		System.out.println("get the student:" + stud);
		session.getTransaction().commit();
		// session.close();
	}

	public static void displayStudent() {
		session.beginTransaction();
		List<StudentEntity> list = session.createQuery("from StudentEntity").list();
		System.out.println("The list of student:" + list);
		session.getTransaction().commit();
		// session.close();
	}

	@SuppressWarnings("deprecation")
	public static void displayByLikeQuery() {
		session.beginTransaction();
		Query query = session.createQuery("from StudentEntity s where s.fname=fname and s.fname like '%V%'");
		List<StudentEntity> listStud = (List<StudentEntity>) query.getResultList();
		session.getTransaction().commit();
		System.out.println("The like query result is:" + listStud);
	}

	@SuppressWarnings("deprecation")
	public static void updateStudent() {
		session.beginTransaction();
		Query query = session.createQuery("update StudentEntity s set s.lname=:lname where s.id=:id");
		query.setParameter("lname", "Bolly");
		query.setParameter("id", 1);
		int i = query.executeUpdate();
		System.out.println("Updated row is:" + i);
		session.getTransaction().commit();
	}

	public static void deleteStudent() {
		session.beginTransaction();
		/*Query q = session.createQuery("delete from StudentEntity s where s.id=:id");
		q.setParameter("id", 2);
		int i = q.executeUpdate();
		System.out.println("Deleted id :" + i);*/
		StudentEntity s=session.get(StudentEntity.class, 1);
		System.out.println(s);
		session.delete(s);
		session.getTransaction().commit();

	}
}
