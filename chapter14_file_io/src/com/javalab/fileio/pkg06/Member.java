package com.javalab.fileio.pkg06;

import java.io.Serializable;

/*
 * 직렬화용 Member 클래스
 */
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4222164728747669091L;
	// 직렬화 역직렬화 시 같은 클래스 타입이라는 것을 증명해주는 역할
	//private static final long serialVersionUID = -622284561026719240L;
	
	private String id;
	private String name;
	
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	
	

}
