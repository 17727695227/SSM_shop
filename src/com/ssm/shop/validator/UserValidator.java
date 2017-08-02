package com.ssm.shop.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssm.shop.user.model.User;


@Repository("userValidator")
public class UserValidator implements Validator{

	//该校验器能够对clzz类型的对象进行校验
	@Override
	public boolean supports(Class<?> clazz) {
		//User指定的class参数所表示的类或者接口是否相同，或是否是其超累或者超接口
		return User.class.isAssignableFrom(clazz);
	}

	//对目标类target进行校验，并将校验错误记录在error中
	@Override
	public void validate(Object target, Errors error) {
		/**
		 使用ValidationUtil中的一个静态方法rejectIfEmpty（）来对
		 username/password属性进行叫校验,假若username属性是null的
		 或者是空的话，就拒绝验证通过
		 */
		
		ValidationUtils.rejectIfEmpty(error, "username", null,"用户名不能为空");
	    ValidationUtils.rejectIfEmpty(error, "password", null,"密码不能为空");
		ValidationUtils.rejectIfEmpty(error, "name", null,"真实姓名不能为空");
		ValidationUtils.rejectIfEmpty(error, "email", null,"邮箱不能为空");
		ValidationUtils.rejectIfEmpty(error, "phone", null,"电话号码不能为空");

		System.out.println(2);
		
		User user = (User)target;
		if(user.getUsername().length()>10){
			error.rejectValue("username", null, "用户名不能超过十个字符");
		}
		if(user.getPassword() !=null && !user.getPassword().equals("")
		   && user.getPassword().length()<6){
			error.rejectValue("password",null,"密码长度不能小于6位");
			System.out.println(3);
		}
		
	}

}
