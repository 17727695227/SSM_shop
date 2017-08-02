package com.ssm.shop.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.shop.user.dao.UserDao;
import com.ssm.shop.user.model.User;
import com.ssm.shop.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
    private UserDao userDao;
	
	
	public List<User> exitUser(User user) {
		return userDao.exitUser(user);
	}

}
