package com.example.base.dao;

import javax.persistence.Entity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.base.model.User;

import java.util.List;

/**
 * The Interface UserJpaDao.
 * @author abel
 */
public interface UserJpaDao extends JpaRepository<User, Long> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the user
	 */
	User findByName(String name);

	/**
	 * Find by name and user name.
	 * 如果参数名为多个字母组成，请首字母大写。勿使用驼峰命名，jpa不识别驼峰
	 * @param name the name
	 * @param userName the age
	 * @return the user
	 */
	User findByNameAndUsername(String name, String userName);

	/**
	 * Find user.
	 * User为@Entity 的名字
	 * @param name the name
	 * @return the user
	 */
	@Query("select u from User u where u.name=:name")
	User findUser(@Param("name") String name);

	/**
	 * 排序返回list
	 * @param name
	 * @param sort
	 * @return
	 * new Sort(new Sort.Order(Sort.Direction.DESC,"weiboId"))
	 */
	List<User> findByNameContaining(String name, Sort sort);


	/**
	 * 分页返回list
	 * @param name
	 * @param pageRequest
	 * @return
	 *
	 * new PageRequest(pageNo,pageSize)
	 */
	List<User> findByUsernameContaining(String name, PageRequest pageRequest);

	@Modifying
	int deleteByUsername(String userName);

}
