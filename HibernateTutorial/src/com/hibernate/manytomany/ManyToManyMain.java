package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.mapping.Instructor;
import com.java.mapping.InstructorDetail;

public class ManyToManyMain {
	static Session session = null;
	static SessionFactory sessionFactory = null;
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Post.class)
				.addAnnotatedClass(Tags.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Post post = new Post("Java with hibernate", "Very good lang", "The content are good");
		Tags tags = new Tags("Hibernate tags");
		Tags tags2 = new Tags("Spring tags");
		post.getTag().add(tags);
		post.getTag().add(tags2);

		tags.getPost().add(post);
		tags2.getPost().add(post);

		session.beginTransaction();
		//session.save(post);
		//session.getTransaction().commit();
		Post p=session.get(Post.class, 2);
		System.out.println(p.getTag());
		//session.delete(p);
		//session.getTransaction().commit();

	}
	
	
	

}
