package tasystem.daos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tasystem.entities.User;

public class Runner {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("unused")
		ApplicationContext appContext = 
		    	  new FileSystemXmlApplicationContext("C:\\Users\\satya\\workspace\\TAsystem\\WebContent\\WEB-INF\\mvc-dispatcher-servlet.xml");
		
		
		UserDAO udao = (UserDAO) appContext.getBean("userdao");

		
		System.out.println("enter");
		
		User user = new User();
		user.setCompanyName("company");
		user.setEmail("email@email.com");
		user.setFirstName("fname");
		user.setLastName("lname");
		user.setPassword("blah");
		user.setStatus("pending");
		
		udao.save(user);
		
		System.out.println("Saved");
		
		user.setFirstName("this is a big name");
		udao.update(user);
		
		System.out.println("Done");
		
	}
	
}
