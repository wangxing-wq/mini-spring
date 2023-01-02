package com.wx.springframework.context.support;

import com.wx.springframework.context.config.BeanDefinition;
import com.wx.springframework.context.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * 可以自动装配的Bean工厂
 * @author 22343
 * @version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
	
	/**
	 * 实例化bean的策略,默认是CgLib
	 */
	private final InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
	
	@Override
	public Object createBean (String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanDefinition, beanName, args);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}
		
		addSingleton(beanName, bean);
		return bean;
	}
	
	
	protected Object createBeanInstance (BeanDefinition beanDefinition,String beanName,Object[] args) {
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor ctor : declaredConstructors) {
			if (null != args && ctor.getParameterTypes().length == args.length) {
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
	}
	
	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}
	
}
