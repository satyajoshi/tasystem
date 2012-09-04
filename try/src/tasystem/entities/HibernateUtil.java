package tasystem.entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory==null)
		sessionFactory = new AnnotationConfiguration().configure()
				/*.addAnnotatedClass(Customer.class)*/.buildSessionFactory();
		
		return sessionFactory;
	}
	
}
