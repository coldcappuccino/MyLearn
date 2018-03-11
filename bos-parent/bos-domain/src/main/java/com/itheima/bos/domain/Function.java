package com.itheima.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Ȩ��ʵ��
 */

public class Function implements java.io.Serializable {

	// Fields
	private String id;
	private Function parentFunction;//��ǰȨ�޵��ϼ�Ȩ��
	private String name;
	private String code;
	private String description;
	private String page;
	private String generatemenu;//�Ƿ����ɲ˵���1��ʾ���ɣ�0��ʾ������
	private Integer zindex;
	private Set roles = new HashSet(0);//��ǰȨ�޶�Ӧ�Ķ����ɫ
	private Set children = new HashSet(0);//��ǰȨ�޵��¼�Ȩ��
	
	
	public Function(){
	  
	}
	
	
	public Function(String id){
	   this.id = id;
	}
	
	public String getpId(){
	   if(parentFunction==null){
	      return "0";
	   }
	   
	   return parentFunction.getId();
	}
	
	public String getId() {
		return id;
	}
	
	public String getText(){
    return name;
  }
	
	public void setId(String id) {
		this.id = id;
	}
	public Function getParentFunction() {
		return parentFunction;
	}
	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getGeneratemenu() {
		return generatemenu;
	}
	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}
	public Integer getZindex() {
		return zindex;
	}
	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}
	public Set getRoles() {
		return roles;
	}
	public void setRoles(Set roles) {
		this.roles = roles;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
}