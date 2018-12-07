package com.connext.serviceImpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.connext.mapper.UserMapper;
import com.connext.pojo.User;
import com.connext.service.UserService;
import com.connext.utils.MD5Utils;

@Service("UserService")
public class UserServiceImple implements UserService{
	
	@Resource
	private UserMapper usermapper;

	public User login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return usermapper.login(map);
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		MD5Utils md5=new MD5Utils();
		String password=md5.encode(user.getPassword());
		usermapper.register(user.getPhone(),password);
	}

	public int checkRegister(String phone) {
		// TODO Auto-generated method stub
		return usermapper.checkRegister(phone);
	}

}
