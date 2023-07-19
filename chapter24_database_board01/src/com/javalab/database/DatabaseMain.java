package com.javalab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMain {

	// [멤버 변수]
	// 1. oracle 드라이버 이름 문자열 상수
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 2. oracle 데이터베이스 접속 경로(url) 문자열 상수
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	// 3. oracle 계정(id/pwd)
	public static String oracleId = "board";
	public static String oraclePwd = "5678";

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
		
		// 2. 게시물 목록 조회 메소드 호출
		getBoardList();
		
		// 3. 새 글 등록 메소드 호출
		// 새 글 등록이 완료되었으면 주석처리 한 후에 답글등록으로 이동
		//insertNewBoard();
		
		// 4. 답글 등록 메소드 호출
		// 어떤 게시물에 답글을 잘지 부모 게시글의 정보를 전달해야 함.
		int replyGroup = 45;	// 부모글의 그룹번호
		int replyOrder = 0;		// 부모글의 그룹 내 순서
		int replyIndent = 0;	// 부모글의 들여쓰기
		//inserReply(replyGroup, replyOrder, replyIndent);
		
		// 5. 게시물 목록 조회 메소드 호출 (반드시 1번 ~ 5번까지)
		int startNo = 1;
		int length = 5;
		//getBoardListTopN(startNo, length);
	
		// 6. 중간에 특정 부분 조회 메소드 호출(5번 ~ 9번까지)
		startNo = 5;
		length = 9;
		//getBoardListPart(startNo, length);
		
		// 7. 게시물 조회수 증가 메소드 호출
		int bno = 2; // 조회수를 증가시킬 게시물 번호
		//updateCount(bno);
		
		// 8. 제목 수정 메소드 호출 
		// 5번 게시물의 제목을 "다섯번째 글"로 수정하세요.
		bno = 5;
		String newTitle = "다섯번째 글";
		//updateTitle(bno, newTitle);
		
		// 9. 삭제 메소드 호출
		// user01님이 작성한 게시물을 모두 삭제하세요.
		bno = 6;	// 삭제할 게시물 번호
		//deleteBoard(bno);
		
		// 10. 자원 반납
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
	
	// 2. 게시물 목록 조회 메소드
	private static void getBoardList() {
		String sql;
		try {
			sql = "SELECT bno, title, member_id, count,";
			sql += " to_char(created_date, 'YYYY-MM-DD') created_date,";
			sql += " reply_group, reply_order, reply_indent";
			sql += " FROM tbl_board";
			sql += " ORDER BY reply_group DESC, reply_order ASC";

			pstmt = con.prepareStatement(sql);
			System.out.println("2. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println();
			System.out.println("2. 전체 게시물 목록");
			// 게시물 목록 제목
			System.out.println("bno" + "\t"
							+ "group" + " "
							+ "order" + " "
							+ "indent" + "\t"
							+ "title" + "\t \t \t \t"
							+ "member_id" + "\t"
							+ "count" + "\t" 
							+ "created_date"
			);

			while(rs.next()) {
				String strInd = "";
				int indent = rs.getInt("reply_indent");
				if(indent > 0) {
					for (int i = 0; i < indent; i++) {
						strInd += " ";
					}
				}
				System.out.println(
								strInd +
								rs.getInt("bno") + "\t"
								+ rs.getInt("reply_group") + "\t"
								+ rs.getInt("reply_order") + "\t"
								+ rs.getInt("reply_indent") + "\t"
								+ rs.getString("title") + "\t"
								+ rs.getString("member_id") + "\t"								
								+ rs.getInt("count") + "\t"
								+ rs.getString("created_date") + "\t"
				);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("2. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}

	// 3. 새 글 등록 메소드
	private static void insertNewBoard() {
		String sql;
		try {
			// 저장할 게시물 세팅
			String title = "프로그램을 통해 등록한 새 글";
			String content = "프로그램을 통해 등록한 새 글 내용";
			String memberId = "user03";
			int replyOrder = 0;	// order는 부모 order + 1 (부모 다음으로 위치하도록)
			int replyIndent = 0; // indent는 부모 indent + 1 (부모보다 한 칸 들여쓰기)
			
			sql = "INSERT INTO tbl_board (bno, title, content, member_id, count,";
			sql += " created_date, reply_group, reply_order, reply_indent)";
			sql += " VALUES(seq_bno.nextval, ?, ?, ?, 0, sysdate, seq_bno.currval, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, memberId);
			pstmt.setInt(4, replyOrder);
			pstmt.setInt(5, replyIndent);
			System.out.println("3. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("3. 새 글 등록 성공");
			} else {
				System.out.println("3. 새 글 등록 실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("3. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}	
	}

	// 4. 답글 등록 메소드 호출
	private static void inserReply(int replyGroup, int replyOrder, int replyIndent) {
		String sql;
		try {
			String title = "[답글2]프로그램을 통해 등록한 새 글";
			String content = "[답글2]프로그램을 통해 등록한 새 글 내용";
			String memberId = "user02";
			
			/*
			 * [1. 현재 부모글에 달린 답글들의 그룹 내 순서 증가(+1)]
			 * - 현재 부모글 아래에 답글이 있는 경우 그 답글들의 그룹 내 순서를 +1 한다.
			 *   왜냐하면 현재 추가될 답글이 부모글 바로 다음에 올 수 있도록 기존 답글들의 
			 *   그룹 내 순서를 +1씩 해서 뒤로 밀어내는 효과를 낸다.
			 * - 뒤로 밀어낸 그 자리를 현재 추가될 답글이 들어간다.
			 *   데이터베이스에 들어가는 순서는 개발자가 정할 수 없다. 
			 *   그래서 나중에 정렬할 때 사용하기 위해서 그렇게 하는 것이다.
			 */
			// 그룹으로 묶인 글들 중에서 현재 답글이 달릴 부모의 그룹 내 순서보다 큰 답글들의 그룹 내 순서 + 1
			// 기존 답글들이 뒤로 한칸씩 밀리는 효과. 밀린 자리를 이후에 달릴 답글이 차지함.
			sql = "UPDATE tbl_board";
			sql += " SET reply_order = reply_order + 1";
			sql += " WHERE reply_group  = ?";
			sql += "   AND reply_order > ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, replyGroup);
			pstmt.setInt(2, replyOrder);
			System.out.println("4. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			System.out.println();
			
			if (result > 0) {
				System.out.println("4. 기존 답글의 order 컬럼 +1 성공");
			} else {
				System.out.println("4. 기존 답글의 order 컬럼 +1 실패");
			}
			
			System.out.println("답글을 저장하기 전에 기존 답글들의 그룹 내 순서 +1 작업 완료 sql : "
					+ sql + " \n reply_group / reply_order / reply_indent : "
					+ replyGroup + " / " + replyOrder + " / " + replyIndent);
			/*
			 * [2. 답글의 저장 작업 시작]
			 */
			sql = "";
			sql = "INSERT INTO tbl_board(bno, title, content, member_id, count, ";
			sql += " created_date, reply_group, reply_order, reply_indent)";
			sql += " VALUES(seq_bno.nextval, ?, ?, ?, 0, SYSDATE, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, memberId);
			pstmt.setInt(4, replyGroup);
			pstmt.setInt(5, replyOrder + 1);
			pstmt.setInt(6, replyIndent + 1);
			
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("4. 답글 저장 성공");
			} else {
				System.out.println("4. 답글 저장 실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("4. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}

	// 5. 게시물 목록 조회 메소드 (1 ~ 5)
	private static void getBoardListTopN(int startNo, int length) {
		String sql;
		try {
			sql = "SELECT a.bno, a.title, a.content, a.member_id, a.count,";
			sql += " a.created_date, a.reply_group, a.reply_order, a.reply_indent";
			sql += " FROM (";
			sql += "     SELECT b.*";
			sql += "     FROM tbl_board b";
			sql += "     ORDER BY reply_group DESC, reply_order ASC";
			sql += "     ) a";
			sql += " WHERE ROWNUM BETWEEN ? AND ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, length);
			System.out.println("5. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("5. " + startNo + " 번 부터 " + length + " 개까지 조회 결과 ");
			while(rs.next()) {
				String strInd = "";
				int indent = rs.getInt("reply_indent");
				if (indent > 0) {
					for (int i = 0; i < indent; i++) {
						strInd += " ";
					}
				}
				System.out.println(
								strInd 
								+ rs.getInt("bno") + "\t"
								+ rs.getInt("reply_group") + "\t"
								+ rs.getInt("reply_order") + "\t"
								+ rs.getInt("reply_indent") + "\t"
								+ rs.getString("title") + "\t"
								+ rs.getString("member_id") + "\t"
								+ rs.getInt("count") + "\t"
								+ rs.getDate("created_date") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("5. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}			
	}

	// 6. 중간에 특정 부분 조회 메소드 (5번 ~ 9번까지) 
	public static void getBoardListPart(int startNo, int length) {
		String sql;
		try {
			sql = "SELECT c.bno, c.title, c.content, c.member_id, c.count, c.created_date,";
			sql += "        c.reply_group, c.reply_order, c.reply_indent";
			sql += " FROM (";
			sql += "     SELECT ROWNUM rnum, a.*";
			sql += "     FROM (";
			sql += "         SELECT b.*";
			sql += "         FROM tbl_board b";
			sql += "         ORDER BY reply_group DESC, reply_order ASC";
			sql += "         ) a";
			sql += "     ) c";
			sql += " WHERE c.rnum BETWEEN ? AND ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, length);
			System.out.println("6. stmt 객체 생성 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("6. " + startNo + " 번 부터 " + length + " 개까지 조회 결과 ");
			while(rs.next()) {
				String strInd = "";
				int indent = rs.getInt("reply_indent");
				if (indent > 0) {
					for (int i = 0; i < indent; i++) {
						strInd += " ";
					}
				}
				System.out.println(
								strInd 
								+ rs.getInt("bno") + "\t"
								+ rs.getInt("reply_group") + "\t"
								+ rs.getInt("reply_order") + "\t"
								+ rs.getInt("reply_indent") + "\t"
								+ rs.getString("title") + "\t"
								+ rs.getString("content") + "\t"
								+ rs.getString("member_id") + "\t"
								+ rs.getInt("count") + "\t"
								+ rs.getDate("created_date") + "\t"
					);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("6. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}
	
	// 7. 게시물 조회수 증가 메소드
	public static void updateCount(int bno) {
		String sql;
		try {
			sql = "UPDATE tbl_board";
			sql += " SET count = count + 1";
			sql += " WHERE bno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			System.out.println("7. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("7. 조회수 증가 성공");
			} else {
				System.out.println("7. 조회수 증가 실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("7. 조회 sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}		
	}
	
	// 8. 제목 수정 메소드
	public static void updateTitle(int bno, String newTitle) {
		String sql = "";
		try {
			sql = "UPDATE tbl_board";
			sql += " SET title = ?";
			sql += " WHERE bno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setInt(2, bno);
			System.out.println("8. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("8. 수정 성공 ");
			} else {
				System.out.println("8. 수정 실패");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("8. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 9. 삭제 메소드
	public static void deleteBoard(int bno) {
		String sql;
		try {
			sql = "DELETE FROM tbl_board";
			sql += " WHERE bno = ?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			System.out.println("9. stmt 객체 생성 성공");
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("9. 삭제 성공");
			} else {
				System.out.println("9. 삭제 실패");
			}
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println("9. sql 명령어 오류 : " + e.getMessage());
		} finally {
			closeResource(pstmt, rs);
		}
	}
	
	// 10. 커넥션 객체 자원 반환
	private static void closeResource() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 오류 : " + e.getMessage());
		}
	}

	// 11. 커넥션 객체 자원 반환
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
