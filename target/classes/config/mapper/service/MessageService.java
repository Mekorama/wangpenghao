package com.connext.service;

import java.util.ArrayList;

import com.connext.pojo.Message;

public interface MessageService {
	
	//删除
	public void delete(String title);
	
	//显示
	public ArrayList<Message> queryAll();
	
	public Message queryByTitle(String title);
	
	//修改
	public void modifyByTitle(Message message);
	
}
