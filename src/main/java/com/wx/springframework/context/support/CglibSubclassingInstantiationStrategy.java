package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib实现实例化对象
 * @author 22343
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
	
	/**
	 * Cglib实例化对象
	 * @param beanDefinition 需要构造对象的BeanDefinition
	 * @param beanName       bean对象名称
	 * @param ctor           bean对象的构造函数
	 * @param args           构造对象的参数
	 * @return 实例化对象
	 * @throws BeansException
	 */
	@Override
	public Object instantiate (BeanDefinition beanDefinition,String beanName,Constructor ctor,Object[] args) throws BeansException {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(beanDefinition.getBeanClass());
		enhancer.setCallback(new NoOp() {});
		if (null == ctor) {
			return enhancer.create();
		}
		return enhancer.create(ctor.getParameterTypes(),args);
	}
}
