package com.java.spring.Example003;


public class Article {
	
	private Integer id;
	
	public Article(Integer id){
		this.id=id;
	}
	public Article(){}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
}
