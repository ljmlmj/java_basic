package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * [static 전역변수]
 *  - JDBC 프로그래밍을 위한 요소들을 모두 멤버변수 즉, 필드 위치로 뽑아올림.
 * 	 본 클래스 어디서라도 사용 가능한 전역변수가 됨.
 * [모듈화]
 *  - 데이터베이스 커넥션 + PreparedStatement + 쿼리시행 작업 모듈
 *  - 실제로 쿼리를 실행하고 결과를 받아오는 부분 모듈
 * [미션]
 * 	- 전체 상품의 정보를 조회하세요.(카테고리가 나오도록)
 */
public class DatabaseMain {

	// [멤버 변수]
	// 1. oracle 드라이버 이름 문자열 상수
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 2. oracle 데이터베이스 접속 경로(url) 문자열 상수
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	// 3. oracle 계정(id/pwd)
	public static String oracleId = "tempdb";
	public static String oraclePwd = "1234";

	// 4. 데이터베이스 연결 객체
	public static Connection con = null;

	// 5. 커넥션 객체를 통해 데이터베이스에 쿼리(SQL)를 실행해주는 객체
	public static PreparedStatement pstmt = null;

	// 6. 실행된 결과를 받아오는 객체
	public static ResultSet rs = null;

	/*----------------------------------- 메인메소드   -----------------------------------*/
	public static void main(String[] args) {
		
		// 1. DB 접속 메소드 호출
		connectDb();

		// 2. 쿼리문 실행 메소드 호출
		selectAllProducts();
		
		// 3. 카테고리가 전자제품인 상품들의 카테고리명, 상품명, 가격을 조회
		String categoryName = "전자제품";
		selectProductsByCategory(categoryName);
		
		// 4. 가격이 25000원 이상인 상품들의 이름과 가격을 조회
		selectProductGatherThan();
	
		// 5. 카테고리별로 카테고리명과 가격의 합계금액을 조회하되 금액이 큰 순서로 정렬
		selectProductGroupByCategory();
		
		// 6. 상품 추가 :: 카테고리:식료품 / 상품ID:기존 번호+1 / 상품명:양배추 / 가격:2000 / 입고일:2022/07/10
		selectProduct();
		
		// 7. 상품가격 변경(수정) 탱크로리 상품의 가격을 600000으로 수정
		updateProductPrice();
		
		// 8. 자원 반납
		closeResource();
	}
	/*----------------------------------- 메인메소드  끝 -----------------------------------*/
	
	// 1. DB 접속 메소드
	public static void connectDb() {
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 연결 성공");

			// 2. 데이터베이스 커넥션
			con = DriverManager.getConnection(DB_URL, oracleId, oraclePwd);
			System.out.println("커넥션 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류  : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("커넥션 연결 오류 : " + e.getMessage());
		} 
	}
	
	// 2. 쿼리문 실행 메소드 호출
	private static void selectAllProducts() {
		try {
			// 3. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "SELECT c.category_id, c.category_name, p.product_id,";
			sql += " p.product_name, p.price,";
			sql += " TO_CHAR(p.receipt_date, ('YYYY-MM-DD')) RECEIPT_DATE";
			sql += " FROM category c";
			sql += " LEFT OUTER JOIN product p ON c.category_id = p.category_id";
			sql += " ORDER BY c.category_id ASC, p.product_id DESC";

			// 4. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			System.out.println("stmt 객체 생성 성공");
			
			// 5. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			rs = pstmt.executeQuery();
			System.out.println();

			System.out.println("[2. 쿼리문 실행 메소드 호출]");
			// 6. rs.next()의 의미 설명
			while (rs.next()) {
				System.out.println(
								rs.getInt("category_id") + "\t" 
								+ rs.getString("category_name") + "\t"
								+ rs.getInt("product_id") + "\t" 
								+ rs.getString("product_name") + "\t" 
								+ rs.getInt("price") + "\t" 
								+ rs.getString("RECEIPT_DATE") + "\t");
			}
		} catch (SQLException e) {
			System.out.println("2. sql 명령어 오류  : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 3. 카테고리가 전자제품인 상품들의 카테고리명, 상품명, 가격을 조회
	public static String selectProductsByCategory(String categoryName) {
		
		try {
			// 3. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "SELECT c.category_id, c.category_name, p.product_id,";
			sql += " p.product_name, p.price,";
			sql += " TO_CHAR(p.receipt_date, ('YYYY-MM-DD')) RECEIPT_DATE";
			sql += " FROM category c";
			sql += " LEFT OUTER JOIN product p ON c.category_id = p.category_id";
			sql += " WHERE category_name = ?";
			sql += " ORDER BY c.category_id ASC, p.product_id DESC";
			
			// 4. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, categoryName);

			
			// 5. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			rs = pstmt.executeQuery();
			System.out.println();

			System.out.println("[3. 카테고리가 전자제품인 상품들의 카테고리명, 상품명, 가격을 조회]");
			// 6. rs.next()의 의미 설명
			while (rs.next()) {
				System.out.println(
								rs.getInt("category_id") + "\t" 
								+ rs.getString("category_name") + "\t"
								+ rs.getInt("product_id") + "\t" 
								+ rs.getString("product_name") + "\t" 
								+ rs.getInt("price") + "\t" 
								+ rs.getString("RECEIPT_DATE") + "\t");
			}
		} catch (SQLException e) {
			System.out.println("3. sql 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
 		return categoryName;
	}

	// 4. 가격이 25000원 이상인 상품들의 이름과 가격을 조회
	private static void selectProductGatherThan() {
		try {
			// 3. statement 객체에 첨가할 내용
			int price = 25000;

			// 4. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "SELECT product_name, price";
			sql += " FROM product";
			sql += " WHERE price >= ?";

			// 5. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);

			// 6. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			rs = pstmt.executeQuery();
			System.out.println();

			// 7. rs.next()의 의미 설명
			System.out.println("[4. 가격이 25000원 이상인 상품들의 이름과 가격을 조회]");
			while (rs.next()) {
				System.out.println(
								rs.getString("product_name") + "\t" 
								+ rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("4. sql 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 5. 카테고리별로 카테고리명과 가격의 합계금액을 조회하되 금액이 큰 순서로 정렬
	private static void selectProductGroupByCategory() {
		try {

			// 3. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "SELECT c.category_name, sum(p.price) amount";
			sql += " FROM category c, product p";
			sql += " WHERE c.category_id = p.category_id";
			sql += " GROUP BY c.category_name";
			sql += " ORDER BY amount DESC";

			// 4. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);

			// 5. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			rs = pstmt.executeQuery();
			System.out.println();

			// 6. rs.next()의 의미 설명
			System.out.println("[5. 카테고리별로 카테고리명과 가격의 합계금액을 조회하되 금액이 큰 순서로 정렬]");
			while (rs.next()) {
				System.out.println(
								rs.getString("category_name") + "\t" 
								+ rs.getInt("amount"));
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("5. sql 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 6. 상품 추가 :: 카테고리:식료품 / 상품ID:기존 번호+1 / 상품명:양배추 / 가격:2000 / 입고일:2022/07/10
	private static void selectProduct() {
		try {
			// 3. 추가할 상품 데이터
			int product_id = 22;
			String product_name = "양배추";
			int price = 2000;
			int category_id = 5;
			String receipt_date = "20220710";
			
			// 4. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "INSERT INTO product (PRODUCT_ID, PRODUCT_NAME, PRICE, CATEGORY_ID, RECEIPT_DATE)";
			sql += " VALUES(?, ?, ?, ?, TO_DATE(?, 'YYYY/MM/DD'))";

			// 5. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			pstmt.setString(2, product_name);
			pstmt.setInt(3, price);
			pstmt.setInt(4, category_id);
			pstmt.setString(5, receipt_date);

			// 6. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			int result = pstmt.executeUpdate();
			System.out.println();

			// 7. rs.next()의 의미 설명
			if (result > 0) {
				System.out.println("6. 상품 추가 성공");
			} else {
				System.out.println("6. 상품 추가 실패");
			}
		} catch (SQLException e) {
			System.out.println("6. 상품 추가 sql 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}	
	}
		
	// 7. 상품가격 변경(수정) 탱크로리 상품의 가격을 600000으로 수정
	private static void updateProductPrice() {
		try {
			// 3. 수정할 상품 데이터
			int price = 600000;
			String product_name = "탱크로리";
			
			// 4. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			String sql;
			sql = "UPDATE product";
			sql += " SET price = ?";
			sql += " WHERE product_name = ?";

			// 5. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, product_name);

			// 6. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			int result = pstmt.executeUpdate();
			System.out.println();

			// 7. rs.next()의 의미 설명
			if (result > 0) {
				System.out.println("7. 상품 수정 성공");
			} else {
				System.out.println("7. 상품 수정 실패");
			}
		} catch (SQLException e) {
			System.out.println("7. 상품 수정 sql 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}	
	}		

	// 8. 커넥션 객체 자원 반환
	private static void closeResource() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 오류 : " + e.getMessage());
		}
	}

	// 8. 커넥션 객체 자원 반환
	private static void closeResource(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 오류 : " + e.getMessage());
		}
	}
}
