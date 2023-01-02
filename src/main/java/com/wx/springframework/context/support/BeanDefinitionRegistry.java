package com.wx.springframework.context.support;


import com.wx.springframework.context.config.BeanDefinition;

/**
 * beanDefinition 注册接口
 * @author 22343
 */
public interface BeanDefinitionRegistry {
	
	/**
	 * 向BeanDefinitionMap 中注册 BeanDefinition
	 * @param beanDefinition 定义bean的描述
	 * @param beanName       注册bean,bean的名称
	 */
	void registerBeanDefinition (String beanName,BeanDefinition beanDefinition);
	
}
