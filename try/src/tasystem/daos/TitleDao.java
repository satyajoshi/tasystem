package tasystem.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import tasystem.entities.Title;


@Repository
public class TitleDao extends HibernateDaoSupport{
	
	
	@Autowired
	public void whatever(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public void save(Title title){
		getHibernateTemplate().save(title);
	}
	
	public boolean check(Title title){
		if (getHibernateTemplate().find("from Title title where title.title_name = 'title.title_name'")!=null) return false;
		else return true;
	}
}
