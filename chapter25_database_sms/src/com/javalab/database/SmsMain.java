package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SmsMain {

	// [멤버 변수]
	// 1. oracle 드라이버 이름 문자열 상수
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 2. oracle 데이터베이스 접속 경로(url) 문자열 상수
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	// 3. oracle 계정(id/pwd)
	public static String oracleId = "sms";
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
		
		// 2. 학과조회 메소드 호출
		selectDept();
		
		// 3. 학생조회 메소드 호출(dept, student)
		selectStudent();
		
		// 4. 교수조회 메소드 호출 (dept, professor)
		selectProfessor();
		
		// 5. 강좌조회 메소드 호출
		selectCourse();
		
		// 6. 수강조회 메소드 호출
		selectEnrollment();
		
		// 7. 김광식 학생이 수강한 강좌조회 메소드 호출
		String stuName = "김광식";
		selectStudentName(stuName);
		
		// 8. 자료구조 강좌를 수강한 모든 학생을 조회 메소드 호출
		String courseName = "자료구조";
		selectCourseName(courseName);
		
		// 9. 자원 반납
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
	
	// 2. 학과 조회 메소드
	private static void selectDept() {
		String sql;
		try {
			sql = "SELECT dept_id, dept_name";
			sql += " FROM tbl_dept";

			pstmt = con.prepareStatement(sql);
			System.out.println("2. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("2. 학과 조회");

			while(rs.next()) {
				System.out.println(								
								rs.getInt("dept_id") + "\t"
								+ rs.getString("dept_name") + "\t"
				);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("2. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}

	// 3. 학생 조회 메소드
	private static void selectStudent() {
		String sql;
		try {
			sql = "SELECT s.stu_id, s.stu_name, s.resident_id, s.gender, s.address, s.grade,";
			sql += "        s.dept_id, d.dept_name";
			sql += " FROM tbl_student s";
			sql += "     LEFT OUTER JOIN tbl_dept d ON s.dept_id = d.dept_id";

			pstmt = con.prepareStatement(sql);
			System.out.println("3. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("3. 학생 조회");

			while(rs.next()) {
				System.out.println(								
								rs.getInt("stu_id") + "\t"
								+ rs.getString("stu_name") + "\t"
								+ rs.getString("resident_id") + "\t"
								+ rs.getString("gender") + "\t"
								+ rs.getString("address") + "\t"
								+ rs.getString("grade") + "\t"
								+ rs.getInt("dept_id") + "\t"
								+ rs.getString("dept_name") + "\t"
				);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("3. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}	
	}

	// 4. 교수 조회 메소드
	private static void selectProfessor() {
		String sql;
		try {
			sql = "SELECT p.professor_id, p.professor_name, p.resident_id, p.dept_id,";
			sql += "        d.dept_name, TO_CHAR(p.hiredate, 'YYYY/MM/DD') hiredate";
			sql += " FROM tbl_professor p";
			sql += "     LEFT OUTER JOIN tbl_dept d ON p.dept_id = d.dept_id";

			pstmt = con.prepareStatement(sql);
			System.out.println("4. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("4. 교수조회");
			
			while (rs.next()) {
				System.out.println(
							rs.getInt("professor_id") + "\t"
							+ rs.getString("professor_name") + "\t"
							+ rs.getString("resident_id") + "\t"
							+ rs.getInt("dept_id") + "\t"
							+ rs.getString("dept_name") + "\t"
							+ rs.getString("hiredate") + "\t"
						);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("4. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}

	// 5. 강좌 조회 메소드
	private static void selectCourse() {
		String sql;
		try {
			sql = "SELECT a.course_id, a.course_name, a.credit, a.professor_id, p.professor_name,";
			sql += "        a.c_date, a.room_id, a.room_name";
			sql += " FROM (";
			sql += "     SELECT c.course_id, c.course_name, c.credit, c.professor_id,";
			sql += "             TO_CHAR(c.c_date, 'YYYY/MM/DD') c_date,";
			sql += "             r.room_id, r.room_name";
			sql += "     FROM tbl_course c";
			sql += "         LEFT OUTER JOIN tbl_classroom r ON c.room_id = r.room_id";
			sql += "     ) a LEFT OUTER JOIN tbl_professor p ON a.professor_id = p.professor_id";

			pstmt = con.prepareStatement(sql);
			System.out.println("5. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("5. 강좌 조회");
			while(rs.next()) {
				System.out.println(
								rs.getInt("course_id") + "\t"
								+ rs.getString("course_name") + "\t"
								+ rs.getString("credit") + "\t"
								+ rs.getInt("professor_id") + "\t"
								+ rs.getString("professor_name") + "\t"
								+ rs.getString("c_date") + "\t"
								+ rs.getInt("room_id") + "\t"
								+ rs.getString("room_name") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("5. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}			
	}

	// 6. 수강 조회 메소드 
	public static void selectEnrollment() {
		String sql;
		try {
			sql = "SELECT e.enrollment_id, s.stu_id, s.stu_name, c.course_id, c.course_name,";
			sql += "        p.professor_id, p.professor_name, e.score,";
			sql += "        TO_CHAR(e.enrollment_date, 'YYYY/MM/DD') enrollment_date,";
			sql += "        r.room_name";
			sql += " FROM tbl_student s,";
			sql += "      tbl_professor p,";
			sql += "      tbl_course c,";
			sql += "      tbl_classroom r,";
			sql += "      tbl_enrollment e";
			sql += " WHERE s.stu_id = e.stu_id";
			sql += "   AND p.professor_id = e.professor_id";
			sql += "   AND c.course_id = e.course_id";
			sql += "   AND r.room_id = c.room_id";

			pstmt = con.prepareStatement(sql);
			System.out.println("6. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("6. 수강 조회");
			while(rs.next()) {
				System.out.println(
								rs.getInt("enrollment_id") + "\t"
								+ rs.getInt("stu_id") + "\t"
								+ rs.getString("stu_name") + "\t"
								+ rs.getInt("course_id") + "\t"
								+ rs.getString("course_name") + "\t"
								+ rs.getInt("professor_id") + "\t"
								+ rs.getString("professor_name") + "\t"
								+ rs.getString("score") + "\t"
								+ rs.getString("enrollment_date") + "\t"
								+ rs.getString("room_name") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("6. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}
	
	// 7. 김광식 학생이 수강한 강좌를 조회 메소드
	public static void selectStudentName(String stuName) {
		String sql;
		try {
			sql = "SELECT e.enrollment_id, c.course_id, c.course_name,";
			sql += " s.stu_id, s.stu_name, d.dept_name";
			sql += " FROM tbl_enrollment e";
			sql += "     LEFT OUTER JOIN tbl_student s";
			sql += "             INNER JOIN tbl_dept d ON s.dept_id = d.dept_id";
			sql += "         ON e.stu_id = s.stu_id";
			sql += "     LEFT OUTER JOIN tbl_course c ON e.course_id = c.course_id";
			sql += " WHERE s.stu_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stuName);
			System.out.println("7. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("7. 김광식 학생이 수강한 강좌");
			
			while (rs.next()) {
				System.out.println(
							rs.getInt("enrollment_id") + "\t"
							+ rs.getInt("course_id") + "\t"
							+ rs.getString("course_name") + "\t"
							+ rs.getInt("stu_id") + "\t"
							+ rs.getString("stu_name") + "\t"
							+ rs.getString("dept_name") + "\t"				
						);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("7. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}
	
	// 8. 자료구조 강좌를 수강한 모든 학생을 조회 메소드
	public static void selectCourseName(String courseName) {
		String sql = "";
		try {
			sql = "SELECT c.course_name, s.stu_id, s.stu_name,";
			sql += "        DECODE(s.grade, 1, '1학년', 2, '2학년', 3, '3학년') grade,";
			sql += "        e.score";
			sql += " FROM tbl_enrollment e";
			sql += "     LEFT OUTER JOIN tbl_student s ON e.stu_id = s.stu_id";
			sql += "     LEFT OUTER JOIN tbl_course c ON e.course_id = c.course_id";
			sql += " WHERE c.course_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, courseName);
			System.out.println("8. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("8. 자료구조 강좌를 수강한 모든 학생");
			while (rs.next()) {
				System.out.println(
							rs.getString("course_name") + "\t"
							+ rs.getInt("stu_id") + "\t"
							+ rs.getString("stu_name") + "\t"
							+ rs.getString("grade") + "\t"
							+ rs.getString("score") + "\t"
						);
			}
			
			System.out.println();
		} catch (SQLException e) {
			System.out.println("8. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 9. 커넥션 객체 자원 반환
	private static void closeResource() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 오류 : " + e.getMessage());
		}
	}

	// 9. 커넥션 객체 자원 반환
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
