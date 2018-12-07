package com.connext.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.connext.utils.MD5Utils;
import com.connext.mapper.UserMapper;
import com.connext.pojo.User;
import com.connext.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper usermapper;

	public User login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return usermapper.login(map);
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		MD5Utils md5=new MD5Utils();
		String password=md5.encode(user.getPassword());
		usermapper.register(user.getPhone(), password);
	}

	@Override
	public int checkRegister(String phone) {
		// TODO Auto-generated method stub
		return usermapper.checkRegister(phone);
	}
}
