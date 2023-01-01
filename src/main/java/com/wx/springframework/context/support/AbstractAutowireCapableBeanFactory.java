package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;

/**
 * 可以自动装配的Bean工厂
 * @author 22343
 * @version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
	
	@Override
	public Object createBean(String name,BeanDefinition beanDefinition){
		Object bean = null;
		try {
			bean = beanDefinition.getBeanClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BeansException("Instantiation of bean failed", e);
		}
		this.addSingleton(name,bean);
		return bean;
	}

}
