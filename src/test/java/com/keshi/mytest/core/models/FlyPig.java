package com.keshi.mytest.core.models;

import java.io.Serializable;

/**
 * @author 
 *	序列化与反序列化
 *	20180625
 */
public class FlyPig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8886780220836388512L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 8886780220836388512L;
	//private static final long serialVersionUID = 1L;
	
	private String AGE = "269";
	private String name;
	private String color;
	transient private String car;
	
	
	public String getName() {
		return name;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FlyPig{" +  
        "name='" + name + '\'' +  
        ", color='" + color + '\'' +  
        ", car='" + car + '\'' +  
        ", AGE='" + AGE + '\'' +  
        //", addTip='" + addTip + '\'' +  
        '}';  
	}
	

}
