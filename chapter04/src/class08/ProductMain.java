package class08;

public class ProductMain {

	public static void main(String[] args) {
		ProductData pd = new ProductData();	// Product 객체 10개 담을 수 있는 배열 참조
		Product[] products = pd.products;
		
		// 전체 상품 목록 출력
		printProduct(products);
		
		// 세탁기의 가격을 조회하시오.
		String tempStr = "세탁기";
		getWashPrice(tempStr, products);
		
		// 구매한 모든 제품의 총액과 평균 가격을 main 메소드에서 출력하세요.
		int sum = getTotalAmount(products);
		double avg = getAvg(products);
		System.out.printf("모든 제품의 가격 총합 : %d, 평균 : %.2f \n", sum, avg);
		System.out.println();
		
		// 제품 중에서 100만원이 넘는 제품의 목록, 수량, 합계 금액 출력
		getProductGrather100(products);
	}

	private static void getProductGrather100(Product[] products) {
		int sum = 0;
		int count = 0;
		System.out.println("[가격이 100만원 이상인 제품]");
		for (Product p : products) {
			if (p.getPrice() >= 1000000 ) {
				sum += p.getPrice();
				count++;
				System.out.println("--------------------------------------------------");
				System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice());
			}	
		}
		System.out.printf("100만원 이상인 제품의 수량은 : %d개 이며 합계 금액은 : %d입니다. \n", count, sum);
		System.out.println();
	}

	private static double getAvg(Product[] products) {
		int sum = getTotalAmount(products);
		int count = 0;
		double avg = 0.0;
		for (Product product : products) {
			count++;
		}
		avg = (double) sum / count;
		return avg;
	}

	private static int getTotalAmount(Product[] products) {
		int sum = 0;
		for (Product product : products) {
			sum += product.getPrice();
		}
		return sum;
	}

	private static void getWashPrice(String tempStr, Product[] products) {
		for (Product product : products) {
			if (product.getName().equals(tempStr)) {
				System.out.printf("%s의 가격은 : %d \n", tempStr, product.getPrice());
			}
		}
		System.out.println();
	}

	private static void printProduct(Product[] products) {
		for (Product product : products) {
			System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice());	
		}
		System.out.println();
	}

}
