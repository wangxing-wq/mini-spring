package com.wx.springframework.context.config;

/**
 * bean定义
 * @author 22343
 * @version 1.0
 */
public class BeanDefinition {
	
	private Class beanClass;
	
	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
	}
	
	public Class getBeanClass() {
		return beanClass;
	}
	
	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}
	
}
