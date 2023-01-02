package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 形式构造对象
 * @author 22343
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
	
	
	/**
	 * InstantiationStrategy 实例化的实现
	 * @param beanDefinition 需要构造对象的BeanDefinition
	 * @param beanName       bean对象名称
	 * @param ctor           bean对象的构造函数
	 * @param args           构造对象的参数
	 * @return               instantiation strategy
	 */
	@Override
	public Object instantiate (BeanDefinition beanDefinition,String beanName,Constructor ctor,Object[] args) throws BeansException {
		Class<?> clazz = beanDefinition.getBeanClass();
		try {
			if (ctor != null) {
				return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
			} else {
				return clazz.getDeclaredConstructor().newInstance();
			}
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
		         InvocationTargetException e) {
			throw new BeansException("Failed to instantiate [" + clazz.getName() + "]",e);
		}
	}
}
