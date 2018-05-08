package com.example.base.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.dao.UserDao;
import com.example.base.dao.UserJpaDao;
import com.example.base.model.User;
import com.example.base.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @ClassName UserServiceImpl
 * @author abel
 * @date 2016年11月10日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserJpaDao userJpaDao;

	/**
	 * 
	 * @param map
	 * @return
	 */
	public Object getList(Map<String, Object> map) {
		return userDao.getList(map);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	@Transactional(value="transactionManager2")//jpa事务
	@Override
	public User getUserByName(String username) {
		return userJpaDao.findByName(username);
	}
	@Transactional(value="transactionManager")//jdbc事务
	@Override
	public User getUserByNameAndUsername(String name, String username) {
		return userJpaDao.findByNameAndUsername(name,username);
	}
}
