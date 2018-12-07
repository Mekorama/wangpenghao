package com.connext.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connext.pojo.User;
import com.connext.service.UserService;
import com.connext.utils.GetImageCode;
import com.connext.utils.MD5Utils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	// 登陆
	@RequestMapping("/login")
	public String login(HttpServletRequest req, Model model) {
		MD5Utils md5 = new MD5Utils();
		String password = md5.encode(req.getParameter("password"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", req.getParameter("phone"));
		map.put("password", password);
		User user = userService.login(map);
		if (user != null) {// 登录成功进入消息页面
			return "redirect:/messagelist/queryAll";
		} else {// 登录失败回到登录页面
			// model.addAttribute("message", "用户名或密码输入错误,请重新输入");
			return "login";
		}
	}

	// 跳转注册页
	@RequestMapping("/doRegister")
	public String doRegister() {
		return "register";
	}

	// 注册
	@RequestMapping("/register")
	public String register(User user) {
		userService.register(user);
		return "login";
	}

	// 注册时验证是否已注册
	@RequestMapping(value = "/checkReg", method = RequestMethod.POST)
	@ResponseBody
	public String checkReg(@RequestParam(value = "phone", required = false) String phone) {
//		System.out.println(userService.checkRegister(phone));
		if (userService.checkRegister(phone)==0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping(value="/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        GetImageCode getImageCode = new GetImageCode();
        try {
        	getImageCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
