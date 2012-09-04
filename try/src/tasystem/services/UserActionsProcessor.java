package tasystem.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tasystem.entities.HibernateUtil;




public class UserActionsProcessor {
	
	public static boolean authenticate(String username, String password, String usertype)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.createSQLQuery("SELECT name, password FROM customers;").iterate();
		return true;
	}
	
	public static int createNewUser(String username, String password, String email)
	{
		System.out.println("UserActionsProcessor.createNewUser()");
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		
//		Customer customer = new Customer(username, password, email);
//		session.beginTransaction();
//		int id = (Integer) session.save(customer);
//		session.getTransaction().commit();
//		session.close();	
		
		return 1;
	}

	public static List<Object[]> getProductsList()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session.createSQLQuery("SELECT productName, productPrice FROM products").list();
	}
	
}
