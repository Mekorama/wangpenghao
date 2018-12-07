package com.connext.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connext.mapper.MessageMapper;
import com.connext.pojo.Message;
import com.connext.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper messagemapper;
	@Override
	public void delete(String title) {
		// TODO Auto-generated method stub
		this.messagemapper.delete(title);
	}

	@Override
	public ArrayList<Message> queryAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Message>) this.messagemapper.queryAll();
	}

	@Override
	public Message queryByTitle(String title) {
		// TODO Auto-generated method stub
		return this.messagemapper.queryByTitle(title);
	}

	@Override
	public void modifyByTitle(Message message) {
		// TODO Auto-generated method stub
		messagemapper.modifyByTitle(message);
	}

	

}
