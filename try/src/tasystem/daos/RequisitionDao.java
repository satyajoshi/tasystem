package tasystem.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import tasystem.entities.Requisition;


@Repository
public class RequisitionDao extends HibernateDaoSupport{
	
	@Autowired
	public void whatever(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public void save(Requisition requisition){
		getHibernateTemplate().save(requisition);
	}
}
