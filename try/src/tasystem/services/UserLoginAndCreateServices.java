package tasystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tasystem.daos.UserDAO;
import tasystem.entities.User;

//@Qualifier("serve")
@Service(value="serve")
public class UserLoginAndCreateServices {
	
	@Autowired
	private UserDAO udao;
	
	public void createNewUser(User user)
	{
		udao.save(user);
	}
	
	public String authenticate(User user)
	{
		return udao.authenticate(user);
	}
	
	public User findUserByEmail(String email)
	{
		return udao.getUserByEmail(email);
	}
}
