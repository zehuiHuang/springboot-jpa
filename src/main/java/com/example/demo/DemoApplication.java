package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

@ComponentScan(basePackages ="com.example")
@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	/**
	 * 检测使用的是jdbc事务还是jpa事务,如果都配置用的是jdbc事务
	 * @param platformTransactionManager
	 * @return
	 */
//	@Bean
//	public Object testBean(PlatformTransactionManager platformTransactionManager){
//		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
//		return new Object();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
