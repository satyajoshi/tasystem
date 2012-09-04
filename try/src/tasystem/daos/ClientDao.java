package tasystem.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import tasystem.entities.Client;



@Repository
public class ClientDao extends HibernateDaoSupport{

	@Autowired
	public void whatever(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public void save(Client client){
		getHibernateTemplate().save(client);
	}
	
	public boolean check(Client client){
		if (getHibernateTemplate().find("from Client client where client.client_manager_email = 'client.client_manager_email'")!=null) return false;
		else return true;
	}
}
