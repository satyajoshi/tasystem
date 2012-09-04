package tasystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/RecruiterHomePage")
public class RecruiterController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String recruiterWelcome(Model model) {
		
		System.out.println("RecruiterController.recruiterWelcome()");
		
	//	model.addAttribute("user", user);
		return "SMEHomePage";
	}

}
