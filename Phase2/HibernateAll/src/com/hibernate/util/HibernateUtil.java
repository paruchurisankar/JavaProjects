package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EProduct;

public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {
		
		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(EProduct.class);
		
		//Step 2
		SessionFactory sf = cfg.buildSessionFactory();

		return sf;
	}

}