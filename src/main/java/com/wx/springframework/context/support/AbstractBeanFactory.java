package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;
import com.wx.springframework.context.factory.BeanFactory;

/**
 * BeanFactory的模板实现,拥有单例Bean和普通BeanFactory的功能
 * @author 22343
 * @version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	
	/**
	 * 根据bean名称获取bean对象
	 * @param name bean的名称
	 * @return name对应的bean对象
	 * @throws BeansException beansException 异常
	 */
	@Override
	public Object getBean (String name) throws BeansException {
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name,beanDefinition);
	}
	
	/**
	 * 获取BeanDefinition
	 * @param beanName name BeanDefinition的名称
	 * @throws BeansException beans异常
	 */
	protected abstract BeanDefinition getBeanDefinition (String beanName) throws BeansException;
	
	/**
	 * 创建Bean
	 * @param beanName       bean名称
	 * @param beanDefinition 创建的beanDefinition
	 * @return 返回根据beanDefinition创建的对象
	 * @throws BeansException beanDefinition构建异常
	 */
	protected abstract Object createBean (String beanName,BeanDefinition beanDefinition,Object ... args) throws BeansException;
	
}
