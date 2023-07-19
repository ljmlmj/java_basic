package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalMain {

	// [멤버 변수]
	// 1. oracle 드라이버 이름 문자열 상수
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 2. oracle 데이터베이스 접속 경로(url) 문자열 상수
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	// 3. oracle 계정(id/pwd)
	public static String oracleId = "hospital";
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
		
		// 2. 홍길동 의사의 담당진료 과목이 '피부과'에서 '소아과'로 변경
		String afterMajor = "소아과";
		String docName = "홍길동";
		updateMajor(afterMajor, docName);
		
		// 3. '김은영' 간호사는 대학원 진학으로 오늘까지만 근무하고 퇴사
		int retired = 1;
		String nurName = "김은영";
		updateNurseRetired(retired, nurName);
		
		// 4. 담당 진료과목이 '소아과'인 의사에 대한 정보를 조회
		String docMajor = "소아과";
		selectDocMajor(docMajor);
		
		// 5. '홍길동' 의사에게 진료를 받은 환자에 대한 모든 정보를 출력
		docName = "홍길동";
		selectPatientToWhoseDoctor(docName);
		
		// 6. 진료날짜가 2013년 12월인 환자에 대한 모든 정보를 오름차순으로 정렬하에 출력
		String startDate = "2013-12-01";
		String endDate = "2013-12-31";
		selectPatientFromTreatDate(startDate, endDate);
		
		// 7. 간호사ID가 05로 시작하는 모든 간호사의 정보를 출력
		String nurseId = "05";
		selectNurseIdStartNum(nurseId);
		
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
	
	// 2. 홍길동 의사의 담당진료 과목이 '피부과'에서 '소아과'로 변경
	private static void updateMajor(String afterMajor, String docName) {
		String sql;
		try {
			sql = "UPDATE tbl_doctors";
			sql += " SET major_treat = ?";
			sql += " WHERE doc_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, afterMajor);
			pstmt.setString(2, docName);
			System.out.println("2. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			System.out.println("2. " + docName + "의사의 담당진료 과목이 " + afterMajor + "로 변경");
			
			if (result > 0) {
				System.out.println("2. 수정 성공  : " + result + "개");
			} else {
				System.out.println("2. 수정 실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("2. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}

	// 3. '김은영' 간호사는 대학원 진학으로 오늘까지만 근무하고 퇴사
	private static void updateNurseRetired(int retired, String nurName) {
		String sql;
		try {
			sql = "UPDATE tbl_nurse";
			sql += " SET retired = ?";
			sql += " WHERE nur_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, retired);
			pstmt.setString(2, nurName);
			System.out.println("3. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			System.out.println("3. " + nurName + " 간호사는 대학원 진학으로 오늘까지만 근무하고 퇴사");
			
			if (result > 0) {
				System.out.println("3. 수정 성공 : " + result + "개");
			} else {
				System.out.println("3. 수정실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("3. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}

	// 4. 담당 진료과목이 '소아과'인 의사에 대한 정보를 조회
	private static void selectDocMajor(String docMajor) {
		String sql;
		try {
			sql = "SELECT doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position";
			sql += " FROM tbl_doctors";
			sql += " WHERE major_treat = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, docMajor);
			System.out.println("4. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("4. 담당 진료 과목이 " + docMajor + "인 의사에 대한 정보를 조회");
			
			while (rs.next()) {
				System.out.println(
							rs.getString("doc_id") + "\t"
							+ rs.getString("major_treat") + "\t"
							+ rs.getString("doc_name") + "\t"
							+ rs.getString("doc_gen") + "\t"
							+ rs.getString("doc_phone") + "\t"
							+ rs.getString("doc_email") + "\t"
							+ rs.getString("doc_position") + "\t"
						);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("4. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
		
	// 5. '홍길동' 의사에게 진료를 받은 환자에 대한 모든 정보를 출력
	private static void selectPatientToWhoseDoctor(String docName) {
		String sql;
		try {
			sql = "SELECT pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin,";
			sql += "      pat_addr, pat_phone, pat_email, pat_job";
			sql += " FROM tbl_patients";
			sql += " WHERE doc_id IN (SELECT doc_id";
			sql += "                  FROM tbl_doctors";
			sql += "                  WHERE doc_name = ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, docName);
			System.out.println("5. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("5. " + docName + " 의사에게 진료를 받은 환자에 대한 모든 정보 출력");
			while(rs.next()) {
				System.out.println(
								rs.getInt("pat_id") + "\t"
								+ rs.getString("nur_id") + "\t"
								+ rs.getString("doc_id") + "\t"
								+ rs.getString("pat_name") + "\t"
								+ rs.getString("pat_gen") + "\t"
								+ rs.getInt("pat_jumin") + "\t"
								+ rs.getString("pat_addr") + "\t"
								+ rs.getString("pat_phone") + "\t"
								+ rs.getString("pat_email") + "\t"
								+ rs.getString("pat_job") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("5. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}			
	}

	// 6. 진료날짜가 2013년 12월인 환자에 대한 모든 정보를 오름차순으로 정렬하에 출력 
	public static void selectPatientFromTreatDate(String startDate, String endDate) {
		String sql;
		try {
			sql = "SELECT p.pat_id, p.nur_id, p.doc_id, p.pat_name, p.pat_gen, p.pat_jumin,";
			sql += "      p.pat_addr, p.pat_phone, p.pat_email, p.pat_job, t.treat_date";
			sql += " FROM tbl_treatments t INNER JOIN tbl_patients p ON t.pat_id = p.pat_id";
			sql += " WHERE t.treat_date BETWEEN TO_DATE(?, 'YYYY-MM-DD')";
			sql += "                        AND TO_DATE(?, 'YYYY-MM-DD')";
			sql += " ORDER BY t.treat_date ASC";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			System.out.println("6. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("6. 진료날짜가 " + startDate + "부터 " + endDate + "까지인 환자에 대한 모든 정보를 오름차순으로 정렬하여 출력");
			while(rs.next()) {
				System.out.println(
								rs.getInt("pat_id") + "\t"
								+ rs.getString("nur_id") + "\t"
								+ rs.getString("doc_id") + "\t"
								+ rs.getString("pat_name") + "\t"
								+ rs.getString("pat_gen") + "\t"
								+ rs.getInt("pat_jumin") + "\t"
								+ rs.getString("pat_addr") + "\t"
								+ rs.getString("pat_phone") + "\t"
								+ rs.getString("pat_email") + "\t"
								+ rs.getString("pat_job") + "\t"
								+ rs.getDate("treat_date") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("6. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}
	
	// 7. 간호사ID가 05로 시작하는 모든 간호사의 정보를 출력
	public static void selectNurseIdStartNum(String nurseId) {
		String sql;
		try {
			sql = "SELECT nur_id, major_job, nur_name, nur_gen,";
			sql += "      nur_phone, nur_email, nur_position, retired";
			sql += " FROM tbl_nurse";
			sql += " WHERE nur_id LIKE CONCAT(?, '%')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nurseId);
			System.out.println("7. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			
			System.out.println("7. 간호사ID가 " + nurseId + " 로 시작하는 모든 간호사의 정보를 출력");
			
			while (rs.next()) {
				System.out.println(
							rs.getString("nur_id") + "\t"
							+ rs.getString("major_job") + "\t"
							+ rs.getString("nur_name") + "\t"
							+ rs.getString("nur_gen") + "\t"
							+ rs.getString("nur_phone") + "\t"
							+ rs.getString("nur_email") + "\t"				
							+ rs.getString("nur_position") + "\t"				
							+ rs.getInt("retired") + "\t"				
						);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("7. 조회 sql 명령어 오류 : " + e.getMessage());
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
