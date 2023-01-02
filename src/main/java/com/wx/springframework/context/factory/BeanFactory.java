package com.wx.springframework.context.factory;

import com.wx.springframework.context.exception.BeansException;

/**
 * 构建bean的工厂接口
 * @author 22343
 * @version 1.0
 */
public interface BeanFactory {
	
	/**
	 * 根据beanName获取bean对象
	 * @param beanName bean对象名称
	 * @return bean对象
	 * @throws BeansException 运行异常
	 */
	Object getBean (String beanName) throws BeansException;
	
	/**
	 * 根据beanName获取bean对象,含参数
	 * @param beanName bean对象名称
	 * @param args     构造参数
	 * @return bean对象
	 * @throws BeansException 运行异常
	 */
	Object getBean (String beanName,Object ... args) throws BeansException;
	
	
}
