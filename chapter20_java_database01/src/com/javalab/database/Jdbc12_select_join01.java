package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc12_select_join01 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 데이터베이스 연결 문자열
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		// 데이터베이스 계정명
		String dbId = "square";
		// 데이터베이스 비밀번호
		String dbPwd = "1234";

		// 데이터베이스에 연결하는 다리와 같다
		Connection con = null; 

		// 쿼리문에 인자를 전달해서 SQL 구문을 실행해주는 객체
		PreparedStatement pstmt = null;

		// 실행된 결과를 받아오는 객체
		ResultSet rs = null;
		
		String sql;

		try {
			// 1. 드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");

			// 2. 데이터베이스 커넥션(연결)
			con = DriverManager.getConnection(url, dbId, dbPwd);
			System.out.println("커넥션 객체 생성 성공!");
			
			// 3. 
			sql = "SELECT o.order_id, o.cust_id, o.book_id,";
			sql += " b.book_name, o.order_date, b.publisher, b.price";
			sql += " FROM book b, orders o";
			sql += " WHERE b.book_id = o.book_id";
			sql += " ORDER BY o.order_id ASC";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("주문 테이블과 도서 테이블을 조인해서 주문정보 + 도서정보가 나오도록 조회");
			
			while (rs.next()) {
				System.out.println(rs.getInt("order_id") + "\t" 
							+ rs.getInt("cust_id") + "\t" 
							+ rs.getInt("book_id") + "\t"
							+ rs.getString("book_name") + "\t"
							+ rs.getDate("order_date") + "\t"
							+ rs.getString("publisher") + "\t"
							+ rs.getInt("price") + "\t");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				System.out.println("커넥션 자원해제 오류 : " + e2.getMessage());
			}
		}
	}

}
