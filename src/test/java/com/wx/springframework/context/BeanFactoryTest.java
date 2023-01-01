package com.wx.springframework.context;


import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.factory.BeanFactory;
import com.wx.springframework.service.UserService;
import org.junit.Before;
import org.junit.Test;

/**
 * 设计代码要考虑到以后的业务,对其进行扩展
 * @author 22343
 * @version 1.0
 */
public class BeanFactoryTest {
	
	private BeanFactory beanFactory = new BeanFactory();
	
	@Before
	public void init(){
		beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));
	}
	
	@Test
	public void registerBeanDefinition() {
		beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));
	}
	
	@Test
	public void getBean() {
		UserService userService = (UserService) beanFactory.getBean("userService");
		System.out.println(userService.queryById(1));
	}
}
