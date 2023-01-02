package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 22343
 * @version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
	
	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
	
	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}
	
	@Override
	public Object getBean (String beanName,Object... args) throws BeansException {
		return null;
	}
}
