package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointMain {

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
		
		// 2. 회원들과 보유 포인터 정보 조회
		getMemeberAndPoint();
		
		// 3. 이소미 회원에게 포인트 15점 추가 지급
		updatePointSomi();
		
		// 4. 관리자에게 포인트 30점 추가 지급
		updatePointManager();
		
		// 5. 전체 회원 평균 포인트보다 작은 회원
		getMemeberLessThanAvg();
	
		// 6. 자원 반납
		closeResource();
	}
	/*----------------------------------- 메인메소드  끝 -----------------------------------*/
	
	// 2. 회원들과 보유 포인터 정보 조회
	private static void getMemeberAndPoint() {
		try {
			String sql;
			sql = "SELECT m.user_id, m.name, m.pwd, m.email, m.phone,";
			sql += " DECODE(m.admin, 0, '일반사용자', 1, '관리자') admin, p.point_id,";
			sql += " p.points, TO_CHAR(p.reg_date, 'YYYY-MM-DD') reg_date";
			sql += " FROM member m LEFT OUTER JOIN point p ON m.user_id = p.user_id";

			pstmt = con.prepareStatement(sql);
			System.out.println("2. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println();

			System.out.println("2. 회원정보와 회원들의 포인터 정보 조회");
			System.out.println("=================================================");
			while(rs.next()) {
				System.out.println(rs.getString("user_id") + " "
								+ rs.getString("name") + " "
								+ rs.getString("pwd") + " "
								+ rs.getString("email") + " "
								+ rs.getString("phone") + " "
								+ rs.getString("admin") + " "
								+ rs.getInt("point_id") + " "
								+ rs.getInt("points") + " "
								+ rs.getString("reg_date")
					);
			}
		} catch (SQLException e) {
			System.out.println("2. 테이블 생성 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}

	// 3. 이소미 회원에게 포인트 15점 추가 지급
	private static void updatePointSomi() {
		try {
			int intPoint = 15;
			String strName = "이소미";
			
			String sql;
			sql = "UPDATE point";
			sql += " SET points = points + ?";
			sql += " WHERE user_id = (SELECT user_id";
			sql += " 				  FROM member WHERE name = ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, intPoint);
			pstmt.setString(2, strName);
			System.out.println("3. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			System.out.println();
			
			if (result > 0) {
				System.out.println("3. 점수 추가 성공");
			} else {
				System.out.println("3. 점수 추가 실패");
			}
		} catch (SQLException e) {
			System.out.println("3. 점수 추가 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}	
	}

	// 4. 관리자에게 포인트 30점 추가 지급
	private static void updatePointManager() {
		try {
			int intPoint = 30;
			int intAdmin = 1;
			
			String sql;
			sql = "UPDATE point";
			sql += " SET points = points + ?";
			sql += " WHERE user_id IN (SELECT user_id";
			sql += " 				  FROM member WHERE admin = ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, intPoint);
			pstmt.setInt(2, intAdmin);
			System.out.println("4. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			System.out.println();
			
			if (result > 0) {
				System.out.println("4. 점수 추가 성공");
			} else {
				System.out.println("4. 점수 추가 실패");
			}
		} catch (SQLException e) {
			System.out.println("4. 점수 추가 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}

	// 5. 전체 회원 평균 포인트보다 작은 회원
	private static void getMemeberLessThanAvg() {
		try {
			String sql;
			sql = "SELECT m.user_id, m.name, m.pwd, m.email, m.phone,";
			sql += " DECODE(m.admin, 0, '일반사용자', 1, '관리자') admin, p.point_id,";
			sql += " p.points, TO_CHAR(p.reg_date, 'YYYY-MM-DD') reg_date";
			sql += " FROM member m LEFT OUTER JOIN point p ON m.user_id = p.user_id";
			sql += " WHERE p.points < ( SELECT AVG(points) FROM point)";

			pstmt = con.prepareStatement(sql);
			System.out.println("5. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println();

			System.out.println("5. 전체 회원 평균 포인트보다 작은 회원");
			System.out.println("=================================================");
			while(rs.next()) {
				System.out.println(rs.getString("user_id") + " "
								+ rs.getString("name") + " "
								+ rs.getString("pwd") + " "
								+ rs.getString("email") + " "
								+ rs.getString("phone") + " "
								+ rs.getString("admin") + " "
								+ rs.getInt("point_id") + " "
								+ rs.getInt("points") + " "
								+ rs.getString("reg_date")
					);
			}
		} catch (SQLException e) {
			System.out.println("5. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}			
	}

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
