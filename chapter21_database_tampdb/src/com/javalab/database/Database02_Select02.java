package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 가격이 25000원 이상인 상품들의 이름과 가격을 조회하시오.
 */
public class Database02_Select02 {

	public static void main(String[] args) {
		// 오라클 드라이버 로딩 문자열
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 데이터베이스 연결 문자열
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		// 데이터베이스명 (계정명)
		String dbId = "tempdb";
		// 데이터베이스 비밀번호
		String dbPwd = "1234";

		// 데이터베이스 연결 객체
		Connection con = null;
		// 커넥션 객체를 통해 데이터베이스에 쿼리(SQL)를 실행해주는 객체
		PreparedStatement pstmt = null;
		// 실행된 결과를 받아오는 객체
		ResultSet rs = null;

		String sql;

		try {
			// 1. 드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");

			// 2. 데이터베이스 커넥션
			con = DriverManager.getConnection(url, dbId, dbPwd);
			System.out.println("커넥션 연결 성공");

			// 3. 생성한 Statement 객체를 통해서 쿼리하기 위한 SQL 쿼리 문장
			sql = "SELECT p.product_name, p.price";
			sql += " FROM product p";
			sql += " WHERE p.price >= 25000";
			sql += " ORDER BY p.price DESC";

			// 4. 커넥션 객체를 통해서 데이터베이스에 쿼리(SQL)를 실행해주는 Statement 얻음
			pstmt = con.prepareStatement(sql);
			System.out.println("stmt 객체 생성 성공");

			// 5. Statement 객체의 executeQuery() 메소드를 통해서 쿼리 실행
			// 데이터베이스에서 조회된 결과가 ResultSet 객체에 담겨옴
			rs = pstmt.executeQuery();
			System.out.println();

			// 6. rs.next()의 의미 설명
			while (rs.next()) {
				System.out.println(rs.getString("product_name") + "\t"
						+ rs.getInt("price"));
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

}
