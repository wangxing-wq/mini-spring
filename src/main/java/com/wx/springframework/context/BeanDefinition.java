package com.wx.springframework.context;

/**
 * bean定义
 * @author 22343
 * @version 1.0
 */
public class BeanDefinition {
	
	private Object bean;
	
	public BeanDefinition(Object bean) {
		this.bean = bean;
	}
	public Object getBean() {
		return bean;
	}
	
}
