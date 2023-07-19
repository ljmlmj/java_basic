package com.javalab.generic.pkg03;

/**
 * 제네릭 클래스 Product
 * - 두 개의 타입 파라미터를 객체 생성 시점에 전달 받는다.
 * 
 * @param <K> 첫 번째 타입 파라미터 : 제품의 종류
 * @param <M> 두 번째 타입 파라미터 : 제품의 모델명
 */
public class Product <K, M> {
	// 필드
	private K kind;
	private M model;
	
	// 메소드
	public K getKind() {
		return kind;
	}
	
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public M getModel() {
		return model;
	}
	
	public void setModel(M model) {
		this.model = model;
	}
	
}
