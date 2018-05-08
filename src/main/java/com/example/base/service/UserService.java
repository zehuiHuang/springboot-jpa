package com.example.base.service;

import java.util.Map;

import com.example.base.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Gets the list.
	 *
	 * @param map the map
	 * @return the list
	 */
	public Object getList(Map<String, Object> map);
	
	/**
	 * Gets the user by name.
	 *
	 * @param username the user name
	 * @return the user by name
	 */
	public User getUserByName(String username);

	public User getUserByNameAndUsername(String name,String username);

	
	
}
