package com.API01.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.API01.model.Book;
import com.API01.model.User;
import com.API01.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Autowired
	private UserService userService;
	//cette page sera appelé par ajax
	@RequestMapping(value="/admin/allUser", method=RequestMethod.GET)
	public ModelAndView DisplayAllUser(){
		ModelAndView model=new ModelAndView();
		model.addObject(userService.getAllUsers());
		return model;
	}
	@RequestMapping(value="/user.dao",method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute User user,BindingResult result,@RequestParam String option){
		ModelAndView model=new ModelAndView("admin");
		User userResult=new User();
		
		if (result.hasErrors())
		{
			
			// INFORMER USER SUR SON ERREUR
		}
		else{
			
			switch(option.toLowerCase()){
			case "add":
				userService.addUser(user);
				userResult=user;
				break;
			case "edit":
				userService.edit(user);
				userResult=user;
				break;
			case "delete":
				 userService.delete(user.getId());
				 userResult=user;
				 break;
			case "search":
			/*	User resultSearch= userService.getUser(user.getId());  A revoir car il faut gerer les differentes recherches souhaités:
				userResult=resultSearch!=null? resultSearch:userResult;
			*/
				break;			
		}
			
		model.addObject(option,userResult);
	}
		return model;
	}
}
