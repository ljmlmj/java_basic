package com.javalab.database;

import java.sql.*;

/**
 * [static 전역변수]
 * JDBC 프로그래밍을 위한 요소들을 모두 멤버변수 즉, 필드 위치로 뽑아올림.
 * 	- 본 클래스 어디서라도 사용가능한 전역변수가 됨.
 */
public class Database01_field{

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
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 연결 성공");

			// 2. 데이터베이스 커넥션
			con = DriverManager.getConnection(DB_URL, oracleId, oraclePwd);
			System.out.println("커넥션 연결 성공");

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
				System.out.println(rs.getInt("category_id") + "\t" + rs.getString("category_name") + "\t"
						+ rs.getInt("product_id") + "\t" + rs.getString("product_name") + "\t" + rs.getInt("price")
						+ "\t" + rs.getString("RECEIPT_DATE") + "\t");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류  : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("sql 명령어 오류 : " + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				System.out.println("자원해제 오류  : " + e2.getMessage());
			}
		}
	}
	/*------------------------------ 메인메소드  끝 ------------------------------*/

}
