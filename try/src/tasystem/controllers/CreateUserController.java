package tasystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tasystem.entities.User;
import tasystem.services.UserLoginAndCreateServices;

@Controller
public class CreateUserController {
	
	@Autowired
	private User user;
	
//	@Qualifier("serve")
//	@Resource(name="serve") 
	@Autowired
	private UserLoginAndCreateServices ulacs;
	
	@RequestMapping(value = { "/createuser" }, method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("CreateUserController.init()");
		model.addAttribute("user", user);
		return "CreateUser";
	}

	@RequestMapping(value = { "/createuser" }, method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
		
		System.out.println("CreateUserController.createUser()");
		
		if(ulacs.findUserByEmail(user.getEmail())!=null)
		{
			String errormsg = "Specified email address is already registered with the system. " +
								"Enter a different email address.";
					
			model.addAttribute("createusererrormsg", errormsg);
			return "CreateUser";
		}
		
		user.setStatus("pending");
		
		ulacs.createNewUser(user);
		
		model.addAttribute("message", "Your request for account has been submitted to the Administrator."+
										"You will be notified on approval at the registered email address.");
		return "DisplayMessage";
	}
}
