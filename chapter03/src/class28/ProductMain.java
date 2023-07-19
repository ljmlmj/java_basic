package class28;

/**
 * 실행클래스
 * - 객체 배열 활용
 */
public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product product = new Product(); // 빈 객체 생성
		
		// 위에서 생성된 객체의 필드값에 직접 접근 불가 (모든 필드가 private)
		//product.id = 1;
		//product.name = "오렌지";
		//product.price = 2000;
		
		// public인 setter 메소드를 통해서 값 저장 (값 할당)
		product.setId(1);
		product.setName("오렌지");
		product.setPrice(2000);
		
		// 객체의 필드에 직접 접근해서 값을 갖고 올 수 없음
		//System.out.println(product.id);
		//System.out.println(product.name);
		//System.out.println(product.price);
		
		// 객체의 값을 갖고 올 수 있는 setter 메소드를 통해서 값 조회
		System.out.println("상품 객체의 값을 getter 메소드로 하나씩 조회");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println();
		
		// 과일 객체를 담을 수 있는 Product Type 배열을 생성한다.
		Product[] productArr = new Product[5];	// Product Array
		productArr[0] = new Product(1, "오렌지", 2000);
		productArr[1] = new Product(2, "사과", 3000);
		productArr[2] = new Product(3, "포도", 4500);
		productArr[3] = new Product(4, "배", 5000);
		productArr[4] = new Product(5, "복숭아", 6000);
		
		for (int i = 0; i < productArr.length; i++) {
			System.out.print(productArr[i].getId() + "\t" 
						+ productArr[i].getName() + "\t"
						+ productArr[i].getPrice() + "\n");
			
		}
		System.out.println();
		
		// 모듈화
		printProduct(productArr);	// 객체 배열에 객체 생성해서 출력
	}

	private static void printProduct(Product[] productArr) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < productArr.length; i++) {
			System.out.print(productArr[i].getId() + "\t" 
						+ productArr[i].getName() + "\t"
						+ productArr[i].getPrice() + "\n");
		}

	}
}