package com.connext.service;

import java.util.ArrayList;

import com.connext.pojo.Message;

public interface MessageService {
	public void delete(String title);
	
	public ArrayList<Message> queryAll();
	
	public Message queryByTitle(String title);
	
	public void modifyByTitle(Message message);
}
