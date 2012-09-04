package tasystem.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import tasystem.entities.User;

@Repository("UserDao")
public class UserDAO extends HibernateDaoSupport{

	@Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
	

	public void save(User user){
		getHibernateTemplate().save(user);
	}
 
	public void update(User user){
		getHibernateTemplate().update(user);
	}
 
	public void delete(User user){
		getHibernateTemplate().delete(user);
	}
	
	public User getUserByEmail(String email)
	{
		List list = getHibernateTemplate().find("from User user where user.email=?", email);
		
		if(list.size() != 1)
			return null;
		
		User us = (User) list.get(0);
		return us;
	}
	
	
	public String authenticate(User user)
	{
//		Object[] params = new Object[3];
//		params[0] = user.getEmail();
//		params[1] = user.getPassword();
//		params[2] = user.getRole();
		
		List list = getHibernateTemplate().find("select status from User user where user.email=? and user.password=? and user.role=?",
												 user.getEmail(), user.getPassword(), user.getRole());
		
		if(list != null)
		{
			return (list.size()==0 ? "invalid" : (String)list.get(0));
		}
		
		return "invalid";
	}
	
}
