package com.wx.springframework.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 22343
 * @version 1.0
 */
public class BeanFactory {
	
	/**
	 * 使用线程安全的Map
	 */
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
	
	
	public void registerBeanDefinition(String beanName,BeanDefinition definition){
		beanDefinitionMap.put(beanName,definition);
	}
	
	public Object getBean(String beanName){
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null){
			throw new RuntimeException("bean name not exist");
		}
		return beanDefinition.getBean();
	}
	
	
}
