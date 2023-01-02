package com.wx.springframework.context;


import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.support.DefaultListableBeanFactory;
import com.wx.springframework.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 设计代码要考虑到以后的业务,对其进行扩展
 * @author 22343
 * @version 1.0
 */
public class BeanFactoryTest {
	
	private DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
	
	@Before
	public void init(){
		beanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));
		beanFactory.createBean("userService",new BeanDefinition(UserService.class),new Object[]{"王兴"});
	}
	
	@Test
	public void registerBeanDefinition() {
	
	}
	
	@Test
	public void getBean() {
		UserService userService = (UserService) beanFactory.getBean("userService");
		UserService singleton = (UserService) beanFactory.getSingleton("userService");
		System.out.println(userService.queryById(1));
		System.out.println(singleton == userService);
	}
	
	@Test
	public void test_parameterTypes() throws Exception {
		Class<UserService> beanClass = UserService.class;
		Constructor<?> [] declaredConstructors = beanClass.getDeclaredConstructors();
		System.out.println(Arrays.toString(declaredConstructors));
		Constructor<?> constructor = declaredConstructors[0];
		System.out.println(Arrays.toString(constructor.getParameterTypes()));
		Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
		UserService userService = declaredConstructor.newInstance("小傅哥");
		System.out.println(userService);
	}
}
