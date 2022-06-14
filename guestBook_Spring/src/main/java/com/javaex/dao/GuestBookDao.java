package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String id = "webdb";
	private String pw = "webdb";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	public List<GuestBookVo> showList() {
		getConnection();
		List<GuestBookVo> gbList = new ArrayList<>();
		
		try {
			String query = "select no, name, content, reg_date from guestbook";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name =rs.getString(2);
				String content = rs.getString(3);
				String regDate = rs.getString(4);
				
				gbList.add(new GuestBookVo(no, name, content, regDate));
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();
		return gbList;
	}
	
	
	public void add(GuestBookVo gbVo) {
		getConnection();
		int count = -1;

		try {
			String query = "insert into guestbook values(seq_guestbook_no.nextval, ?, ?, ?, sysdate)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gbVo.getName());
			pstmt.setString(2, gbVo.getPassword());
			pstmt.setString(3, gbVo.getContent());
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();
		if (count > 0) System.out.println("[" + count + "건 등록되었습니다.]");
		else System.out.println("[등록되지 않았습니다.]");
	}
	
	
	public int find(GuestBookVo gbVo) {
		getConnection();
		int no = -1;
		
		try {
			String query = "select no from guestbook where no = ? and password = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gbVo.getNo());
			pstmt.setString(2, gbVo.getPassword());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) no = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();
		return no;
	}
	
	
	public void delete(int no) {
		getConnection();
		int count = -1;
		
		try {
			String query = "delete from guestbook where no = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();
		if (count > 0) System.out.println("[" + count + "건 삭제되었습니다.]");
		else System.out.println("[삭제되지 않았습니다.]");
	}
	
	
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
}
