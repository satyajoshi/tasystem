package tasystem.daos;

import java.util.Set;
import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import tasystem.entities.Position;


@Repository
public class PositionDao extends HibernateDaoSupport{
	
	@Autowired
	public void whatever(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public void save(Position position){
		getHibernateTemplate().save(position);
	}
	
}
