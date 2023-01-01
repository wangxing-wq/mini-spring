package com.wx.springframework.context.config;

/**
 * 单例Bean注册
 * @author 22343
 * @version 1.0
 */
public interface SingletonBeanRegistry {
	
	/**
	 * 获取单例Bean
	 * @param beanName bean名称
	 * @return 对象
	 */
	Object getSingleton(String beanName);
	
}
