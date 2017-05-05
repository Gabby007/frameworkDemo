package com.emma.domain;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int age;
	private String nice_name;
	private String user_name;
	private String course;
	
	public User(){}
	public User(int id, String user_name, int age) {
		this.age = age;
		this.id = id;
		this.user_name = user_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNice_name() {
		return nice_name;
	}
	public void setNice_name(String nice_name) {
		this.nice_name = nice_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override 
	public String toString(){
		return "User [id=" + id + ", nice_name=" + nice_name + ", user_name=" + user_name + ",course=" + course+"]";
	}
}
