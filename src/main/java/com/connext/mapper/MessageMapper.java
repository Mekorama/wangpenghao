package com.connext.mapper;

import java.util.ArrayList;

import com.connext.pojo.Message;

public interface MessageMapper {
	public void delete(String title);
	public ArrayList<Message> queryAll();
	public Message queryByTitle(String title);
	public void modifyByTitle(Message message);
	
}
