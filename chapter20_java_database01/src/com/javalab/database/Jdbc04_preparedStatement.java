package com.javalab.database;

import java.sql.*;

/*
 * PreparedStatement 사용 예제
 */
public class Jdbc04_preparedStatement {

	public static void main(String[] args) {
		// 오라클 드라이버 로딩 문자열
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 데이터베이스 연결 문자열
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		// 데이터베이스 계정명
		String dbId = "square";
		// 데이터베이스 비밀번호
		String dbPwd = "1234";
		
		Connection con = null;
		// 쿼리문에 인자를 전달해서 SQL 구문을 실행해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 로드 성공!");

			// 2. 데이터베이스 커넥션(연결)
			con = DriverManager.getConnection(url, dbId, dbPwd);
			System.out.println("2. 커넥션 객체 생성 성공!");

			// 3. 쿼리문에 인자 전달
			int bookId = 5; // bookId가 5인 도서 조회
			sql = "select * from book where book_id = ?";
			
			// 쿼리문에 인자를 전달해서 SQL 구문을 실행해주는 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			
			System.out.println("3. 조회하신 도서는?");
			
			while (rs.next()) {
				System.out.println(rs.getInt("book_id") + "\t" 
								+ rs.getString("book_name") + "\t"
								+ rs.getInt("price"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 명령어 오류" + e.getMessage());
		}
	}
}
