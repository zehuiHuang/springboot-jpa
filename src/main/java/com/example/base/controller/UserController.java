package com.example.base.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.base.service.ServiceEmail;
import com.example.base.service.UserService;
import com.example.base.util.CommonUtil;

/**
 * 
 * @ClassName UserController
 * @author abel
 * @date 2016年11月10日
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ServiceEmail serviceEmail;

	/***
	 * api :localhost:8099/users?id=99 
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Object> list(HttpServletRequest request) {
		Map<String, Object> map = CommonUtil.getParameterMap(request);
		return new ResponseEntity<>(userService.getList(map), HttpStatus.OK);
	}

	/**
	 * 通过spring data jpa 调用方法
	 * api :localhost:8099/users/byname?username=xxx
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/byname", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUser(HttpServletRequest request) {
		Map<String, Object> map = CommonUtil.getParameterMap(request);
		String username = (String) map.get("username");
		return new ResponseEntity<>(userService.getUserByName(username), HttpStatus.OK);
	}

	/**
	 * http://localhost:8099/users/eamil
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "eamil")
	public String sayHello() {
		try {
			serviceEmail.email();
		} catch (Exception e) {
			logger.error("发送邮件异常[" + e.getMessage() + "]");
		}
		return "邮件发送成功";
	}


	/**
	 * 通过spring data jpa 调用方法
	 * api :localhost:8099/users/bynameAndUsername?username=xxx&name=XXX
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/bynameAndUsername", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserByName(HttpServletRequest request) {
		Map<String, Object> map = CommonUtil.getParameterMap(request);
		String username = (String) map.get("username");
		String name = (String) map.get("name");
		return new ResponseEntity<>(userService.getUserByNameAndUsername(name,username), HttpStatus.OK);
	}
}
