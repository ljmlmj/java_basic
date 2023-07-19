package com.javalab.database;

import java.sql.*;

/**
 * PreparedStatement를 통한 삭제 처리
 */
public class Jdbc07_delete {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String dbId = "square";
		String dbPwd = "1234";

		Connection con = null;
		PreparedStatement pstmt = null; // PreparedStatement 객체 변수
		ResultSet rs = null; // select의 결과 객체 저장

		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");

			con = DriverManager.getConnection(url, dbId, dbPwd);

			// delete
			int result = 0;
			int bookId = 14;
			String query = "delete from book where book_id = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("삭제 성공!!");
			} else {
				System.out.println("삭제 실패!!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("sql 로드 오류 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				System.out.println("자원해제 오류 : " + e2.getMessage());
			}
		}
	}
}
