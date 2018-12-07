package com.connext.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.connext.pojo.Message;
import com.connext.service.MessageService;
import com.connext.serviceImpl.MessageServiceImpl;

@Controller
@RequestMapping("/messagelist")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Resource
	MessageServiceImpl messageImpl;
	
	//删除消息
	@RequestMapping("/delete")
	public String delete(String title){	
		this.messageService.delete(title);
		return "redirect:/messagelist/queryAll";
	}
	
	//修改跳转
	@RequestMapping("/message_modi")
	public String message_modi(String title,HttpServletRequest request,Model model) {
		ArrayList<Message> messagelist=messageImpl.queryAll();
		request.setAttribute("messagelist", messagelist);
		model.addAttribute("messagelist",messagelist);
		return "messagedetail";
	}
	
	//修改内容  
	@RequestMapping(value="/modifyByTitle",method=RequestMethod.POST)
	@ResponseBody
	public String modifyByTitle(@RequestParam(value="title",required=false)String title,@RequestParam(value="date",required=false)String date,@RequestParam(value="content",required=false)String content,HttpServletRequest request){
		final Message aa=new Message();
		aa.setTitle(title);
		SimpleDateFormat bb=new SimpleDateFormat("yyyy-MM-dd");
		try {
			aa.setDate(bb.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aa.setContent(content);
		messageImpl.modifyByTitle(aa);
		ArrayList<Message> messageList=messageImpl.queryAll();
		request.setAttribute("messageList",messageList);
		return "success";
	}
	
	//展示消息
	@RequestMapping("/queryAll")	
	public ModelAndView queryAll(){
		ModelAndView mv = new ModelAndView("messagelist");
		List<Message> messageList=this.messageService.queryAll();
		mv.addObject("messageList", messageList);
		return mv;
	}
	
	
	@RequestMapping("/queryByTitle")	
	public String queryByTitle(String title,Model model){
		Message message=this.messageImpl.queryByTitle(title);
		model.addAttribute("message", message);
		return "messagedetail";
	}
	
	//跳转消息页面
	@RequestMapping("/doMessage")
	public String doMessage(){
		return "messagelist";
	}
	
}
