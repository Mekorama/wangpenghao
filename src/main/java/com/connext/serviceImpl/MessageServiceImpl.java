package com.connext.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.connext.mapper.MessageMapper;
import com.connext.pojo.Message;
import com.connext.service.MessageService;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{
	
	private MessageMapper messagemapper;

	public void delete(String title) {
		// TODO Auto-generated method stub
		this.messagemapper.delete(title);
	}

	public ArrayList<Message> queryAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Message>)this.messagemapper.queryAll();
	}

	public Message queryByTitle(String title) {
		// TODO Auto-generated method stub
		return this.messagemapper.queryByTitle(title);
	}

	public void modifyByTitle(Message message) {
		// TODO Auto-generated method stub
		messagemapper.modifyByTitle(message);
	}
}
