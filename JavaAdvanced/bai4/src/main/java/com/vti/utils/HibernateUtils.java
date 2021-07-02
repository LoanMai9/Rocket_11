package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Image;
import com.vti.entity.Question;
import com.vti.entity.RegistrationUserToken;
import com.vti.entity.ResetPasswordToken;
import com.vti.entity.Testing;
import com.vti.entity.TestingCategory;
import com.vti.entity.User;

public class HibernateUtils {
	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;
	
	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}
	
	private HibernateUtils() {
		configure();
	}
	
	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity: có bn cái thì add cả
		
		configuration.addAnnotatedClass(TestingCategory.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(Question.class);
		configuration.addAnnotatedClass(Image.class);
		configuration.addAnnotatedClass(ResetPasswordToken.class);
		configuration.addAnnotatedClass(RegistrationUserToken.class);
		configuration.addAnnotatedClass(Testing.class);
	}
	
	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}
	
	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
	
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}
}
