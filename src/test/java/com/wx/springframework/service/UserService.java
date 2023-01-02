package com.wx.springframework.service;

/**
 * @author 22343
 * @version 1.0
 */
public class UserService {

	private String name;
	
	public UserService(String name){
		this.name = name;
	}
	public String queryById(int id){
		System.out.println("当前查询用户:\t" + name);
		return Integer.toString(id);
	}

}
