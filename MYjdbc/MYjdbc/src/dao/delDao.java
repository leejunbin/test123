package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.delDto;
import jdbc.JdbcUtil;

public class delDao {
	//택배기사 추가메소드
	public void insert(delDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="insert into delinfo values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getDelcode());
			pstmt.setString(2, dto.getDelname());
			pstmt.setString(3, dto.getDelphone());
			pstmt.setString(4, dto.getDelmail());
			pstmt.setInt(5, dto.getCompanycode());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<택배기사 등록완료!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<택배기사 등록실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//택배기사 삭제메소드
	public void delete(int number) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="delete from delinfo where delcode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<택배기사 삭제완료>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<택배기사 삭제실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//택배기사 수정메소드
	public void update(delDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update delinfo set delname=?,delphone=?,delmail=? where delcode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getDelname());
			pstmt.setString(2, dto.getDelphone());
			pstmt.setString(3, dto.getDelmail());
			pstmt.setInt(4, dto.getDelcode());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<택배기사 정보수정 완료!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<정보수정 실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	//택배기사 전체조회
	public ArrayList<delDto> selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from delinfo";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<delDto> list=new ArrayList<delDto>();
			while(rs.next()) {
				int delcode=rs.getInt("delcode");
				String delname=rs.getString("delname");
				String delphone=rs.getString("delphone");
				String delmail=rs.getString("delmail");
				int companycode=rs.getInt("companycode");
				delDto dto=new delDto(delcode, delname, delphone, delmail, companycode);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	//택배기사 검색 메소드
	public ArrayList<delDto> select(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from delinfo where delcode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<delDto> list=new ArrayList<delDto>();
			rs.next();
			int delcode=rs.getInt("delcode");
			String delname=rs.getString("delname");
			String delphone=rs.getString("delphone");
			String delmail=rs.getString("delmail");
			int companycode=rs.getInt("companycode");
			delDto dto=new delDto(delcode, delname, delphone, delmail, companycode);
			list.add(dto);
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}	
}
