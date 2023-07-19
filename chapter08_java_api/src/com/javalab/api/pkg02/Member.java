package com.javalab.api.pkg02;

public class Member extends Object {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	// 최고 조상인 Object가 갖고 있는 equals메소드 재정의함.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member mem = (Member)obj;
			if (id.equals(mem.id)) {
				return true;
			}
		}
		return false;
	}
	
}
