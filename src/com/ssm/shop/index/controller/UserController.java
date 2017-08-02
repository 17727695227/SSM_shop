package com.ssm.shop.index.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.shop.user.model.User;
import com.ssm.shop.user.service.UserService;
import com.ssm.shop.validator.UserValidator;

/**
 * 用户
 * @author zhiwei
 *
 */
@Controller
@RequestMapping("/shop")
public class UserController {

	private static final Log logger = LogFactory.getLog(UserController.class);
	@Resource
	private UserService userService;
	
    @Autowired
    @Qualifier("userValidator")
	private UserValidator userValidator;
	
   
	//异步校验，看用户是否已经被注册
	@RequestMapping("/findByName")
	public String findByName(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
		List<User> userExit=userService.exitUser(user);
		//向页面输出
		System.out.println("成功");
		response.setContentType("text/html;charset=UTF-8");
		
		if (userExit.size()>0) {
            response.getWriter().println("<font color='red'>用户已经存在</font>");
		}
		else {
			response.getWriter().println("<font color='red'>用户名可用</font>");
		}
		return null;
	}
	
	@RequestMapping(value="/{forName}")
	public String registerForm(@PathVariable String forName,
			Model model){
		User user = new User();
		model.addAttribute("user",user);
		return forName;
	}
	
	
	
	@RequestMapping("/register")
	public String register(@ModelAttribute User user,
			Model model,Errors errors){
		logger.info(user);
		
		model.addAttribute("user",user);
		 // 调用userValidator的验证方法
		userValidator.validate(user, errors);
		System.out.println(1);
		if(errors.hasErrors()){
			return "register";
		}
		return "index";
	}
	
	
	
}
