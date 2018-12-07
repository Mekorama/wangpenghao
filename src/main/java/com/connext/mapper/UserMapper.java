package com.connext.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.connext.pojo.User;

public interface UserMapper {

	public User login(Map<String, String> map);
	
	public void register(User user);	
	
	public int checkRegister(@Param("phone")String phone);

	public void register(String phone, String password);
}
