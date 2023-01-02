package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * 实例化对象的策略实现接口,策略模式的体现,可以根据策略接口,动态选用实例化的InstantiationStrategy
 * @author 22343
 */
public interface InstantiationStrategy {
	
	/**
	 * 根据BeanDefinition实例化对象
	 * @param beanDefinition 需要构造对象的BeanDefinition
	 * @param beanName       bean对象名称
	 * @param ctor           bean对象的构造函数
	 * @param args           构造对象的参数
	 * @return 实例化对象
	 * @throws BeansException 运行异常
	 */
	Object instantiate (BeanDefinition beanDefinition,String beanName,Constructor ctor,Object[] args) throws BeansException;
}
