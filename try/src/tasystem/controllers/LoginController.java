package tasystem.controllers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tasystem.entities.User;
import tasystem.services.UserLoginAndCreateServices;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class LoginController {
	
	@Autowired
	private User user;
	
	@Autowired
	private UserLoginAndCreateServices ulacs;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String gotoLogin(Model model) {
		System.out.println("LoginController.gotoLogin()");
		model.addAttribute("user", user);
		return "LoginForm";
	}
	
	
	@RequestMapping(value = { "/loginhelp" }, method = RequestMethod.GET)
	public String gotoLoginHelp() {
		System.out.println("LoginController.gotoLoginHelp()");
		return "LoginHelp";
	}
	
	@RequestMapping(value = { "/getpassword" }, method = RequestMethod.POST)
	public String gotoLogin(Model model, HttpServletRequest request) {
		String email = request.getParameter("email");
		System.out.println("comes here!" + email);
		
		User user = ulacs.findUserByEmail(email);
			
		if(user == null)
		{
			String emailerror = "Specified email address is not registered with the system. Please try again.";
			model.addAttribute("emailerror", emailerror);
			return "LoginHelp";			
		}
			
		String password = user.getPassword();
		String name = user.getFirstName();
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("Yash.TAsystem","tasystem");
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("email"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("satya.joshi84@gmail.com"));
			message.setSubject("Yash Talent Acquisition System Login Help");
			message.setText("Dear " + name +"," +
					"\n\n Your password for your account is: " + password);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
		model.addAttribute("message", "Your password has been sent at: "+email);
		return "DisplayMessage";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user, BindingResult result, Model model) {
		
		System.out.println("LoginController.userLogin()");

		String role = user.getRole();
		String res = ulacs.authenticate(user);
				
		if(res.equalsIgnoreCase("invalid"))
		{
			model.addAttribute("loginmsg", "Invalid email/password specified. Please try again.");
			return "LoginForm";
		}
		else if(res.equalsIgnoreCase("pending"))
		{
			model.addAttribute("loginmsg", "Your account is pending approval. Please try to login after you get an approval notification by email.");
			return "LoginForm";		//TODO set a flag to display on login page that your account is pending approval.
		}
		else
		{
			if(role.equalsIgnoreCase("admin"))
				return "AdminHomePage";
			else if(role.equalsIgnoreCase("techlead"))
				return "TechLeadHomePage";
			else if(role.equalsIgnoreCase("SME"))
				return "SMEHomePage";
			else
				return "redirect:/RecruiterHomePage";
		}


	}
}
