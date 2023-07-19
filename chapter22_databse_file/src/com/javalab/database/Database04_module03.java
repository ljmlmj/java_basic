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
public class Database04_module03 {

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

	/*------------------------------ 메인메소드   ------------------------------*/
	public static void main(String[] args) {
		
		// 1. DB 접속 메소드 호출
		connectDb();

		// 2. 쿼리문 실행 메소드 호출
		selectAllProducts();
		
		// 3. 카테고리가 전자제품인 상품들의 카테고리명, 상품명, 가격을 조회
		String categoryName = "전자제품";
		selectProductsByCategory(categoryName);
		
		// 4. 자원 반납
		closeResource();
	}
	/*------------------------------ 메인메소드  끝 ------------------------------*/

	// DB 접속 메소드
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
	
	// 쿼리문 실행 메소드 호출
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
			System.out.println("sql 명령어 오류  : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e2) {
				System.out.println("자원 해제 오류 : " + e2.getMessage());
			}
		}
	}
	
	// 3. 특정 카테고리에 소속된 상품들만 조회하는 메소드
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
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e2) {
				System.out.println("자원 해제 오류 : " + e2.getMessage());
			}
		}
 		return categoryName;
	}

	// 커넥션 객체 자원 반환
	private static void closeResource() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 오류 : " + e.getMessage());
		}
	}
}
