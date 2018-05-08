package com.example.base.dao;

import java.util.List;
import java.util.Map;

import com.example.base.model.User;
import com.example.config.MyBatisRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MyBatisRepository
//@Repository
public interface UserDao {
	public List<User> getList(Map<String, Object> map);
}
