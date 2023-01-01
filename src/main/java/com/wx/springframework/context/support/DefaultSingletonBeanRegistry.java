package com.wx.springframework.context.support;

import com.wx.springframework.context.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例Bean的实现
 * @author 22343
 * @version 1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	
	private final Map<String, Object> singletonObjects = new HashMap<>();
	
	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}
	
	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjects.put(beanName, singletonObject);
	}
}
