package com.javalab.collection.pkg13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProductMain {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "자전거", 250000));
		products.add(new Product(2, "노트북", 1250000)); 
		products.add(new Product(3, "쌀", 150000)); 
		products.add(new Product(4, "세탁기", 800000));  
		products.add(new Product(5, "시금치", 2500));
		products.add(new Product(6, "대파", 10000));
		products.add(new Product(7, "에어컨", 3500000));
		products.add(new Product(8, "쇼파", 3000000));
		products.add(new Product(9, "우유", 2500));
		products.add(new Product(10, "운동화", 600000));
		
		// [문제. 1] 전체 상품 목록 출력 메소드 호출 (수동으로 메소드 시그너처 생성)
		printAllProduct(products);
		
		// [문제. 2] 원하는 상품을 파라미터로 전달받아서 검색해주는 메소드를 만들고 해당 상품 가격을 main()메소드 에서 출력하세요.
		System.out.println("[문제. 2] 원하는 상품을 파라미터로 전달받아서 검색해주는 메소드를 만들고 해당 상품 가격을 main()메소드 에서 출력하세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.printf("%s의 가격 : %d \n", name, getProductPrice(products, name));
		System.out.println();
	
		// [문제. 3] 구매한 제품의 평균 구매 가격을 조회해서 main 메소드에서 출력
		System.out.printf("구매한 제품의 평균 구매 가격 : %.2f \n", getAverage(products));
		System.out.println();
		
		// [문제. 4] 제품 중에서 100만원이 넘는 제품들을 찾아서 ArrayList로 반환해주는 메소드를 만들고 main()메소드에서 출력하세요.
		ArrayList<Product> product = product100List(products);
		for (Product p : product) {
			System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice());
		}
		System.out.println();
		
		// [문제. 5] HashMap을 통한 제품 출력 메소드 만들기
		printProductMap(products);
	}
	/**
	 * [문제. 1] 전체 상품 목록 출력 메소드 호출 (수동으로 메소드 시그너처 생성)
	 * @param products
	 */
	private static void printAllProduct(List<Product> products) {
		System.out.println("[문제. 1] 전체 상품 목록 출력 메소드 호출 (수동으로 메소드 시그너처 생성)");
		for (Product p : products) {
			System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice()); 
		}
		System.out.println();
	}
	 
	/**
	 * [문제. 2] 원하는 상품을 파라미터로 전달받아서 검색해주는 메소드를 만들고 해당 상품 가격을 main()메소드 에서 출력하세요.
	 * @param products
	 * @param name
	 * @return
	 */
	private static int getProductPrice(List<Product> products, String name) {
		int price = 0;
		for (Product p : products) {
			if (name.equals(p.getName())) {
				price = p.getPrice();
			}
		}
		return price;
	}

	/**
	 * [문제. 3] 구매한 제품의 평균 구매 가격을 조회해서 main 메소드에서 출력
	 * @param products
	 * @return
	 */
	private static double getAverage(List<Product> products) {
		System.out.println("[문제. 3] 구매한 제품의 평균 구매 가격을 조회해서 main 메소드에서 출력");
		int count = 0;
		int sum = 0;
		double avg =0;
		
		for (Product p : products) {
			count++;
			sum += p.getPrice();
		}
		avg = (double) sum / count;
		return avg;
	}
	
	/**
	 * [문제. 4] 제품 중에서 100만원이 넘는 제품들을 찾아서 ArrayList로 반환해주는 메소드를 만들고 main()메소드에서 출력하세요.
	 * @param products
	 * @return
	 */
	private static ArrayList<Product> product100List(List<Product> products) {
		System.out.println("[문제. 4] 제품 중에서 100만원이 넘는 제품들을 찾아서 ArrayList로 반환해주는 메소드를 만들고 main()메소드에서 출력하세요.");
		ArrayList<Product> products2 = new ArrayList<>();
		for (Product p : products) {
			if (p.getPrice() > 1000000) {
				products2.add(p);
			}
		}
		return products2;
	}
		
	/**
	 * [문제. 5] HashMap을 통한 제품 출력 메소드 만들기
	 * @param products
	 */
	private static void printProductMap(List<Product> products) {
		Map<Integer, Product> mapProduct = new HashMap<>();
		mapProduct.put(1, new Product(1, "자전거", 250000));
		mapProduct.put(2, new Product(2, "노트북", 1250000));
		mapProduct.put(3, new Product(3, "쌀", 150000));
		mapProduct.put(4, new Product(4, "세탁기", 800000));
		mapProduct.put(5, new Product(5, "시금치", 2500));
		mapProduct.put(6, new Product(6, "대파", 10000));
		mapProduct.put(7, new Product(7, "에어컨", 3500000));
		mapProduct.put(8, new Product(8, "쇼파", 3000000));
		mapProduct.put(9, new Product(9, "우유", 2500));
		mapProduct.put(10, new Product(10, "운동화", 600000));
		
		System.out.println("[문제. 5] HashMap을 통한 제품 출력 메소드 만들기");
		Set<Integer> keySet = mapProduct.keySet();
	    Iterator<Integer> iter = keySet.iterator();
	    while(iter.hasNext()) {
	    	Integer key = iter.next();
	    	System.out.printf("%d \t %s \t %d \n", mapProduct.get(key).getId(), mapProduct.get(key).getName(), mapProduct.get(key).getPrice());      
	    }
	}
}
