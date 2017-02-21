package net.codejava.spring;

import java.util.List;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		
		List<User> listUsers = userDao.list("nga");
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	@RequestMapping(value="/testDatabase")
	public String getStuff() {
		System.out.println("****************TEST***************");
		List<User> listUsers = userDao.list("nsa");
		for(User u:listUsers)
		{
			System.out.println(u.getUsername() + " " + u.getEmail());
		}

		return "test";
	}
}
