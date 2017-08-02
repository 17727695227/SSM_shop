package com.ssm.shop.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author zhiwei
 *
 */
@Controller
@RequestMapping("/shop")
public class IndexController {

	//首页
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	//登录页面
	@RequestMapping("/regist")
	public String regist(){
		return "register";
	}
	
	
}
