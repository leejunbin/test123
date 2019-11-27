package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.customerDto;
import jdbc.JdbcUtil;

public class customerDao {
	//회원 추가 메소드
	public void insert(customerDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="insert into customer values(custom_seq.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCmail());
			pstmt.setString(3, dto.getCphone());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<회원추가 완료!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<회원등록 실패..>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//회원 탈퇴메소드
	public void delete(int number) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="delete from customer where cnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<회원탈퇴 완료>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<회원탈퇴 실패..>>");
				System.out.println("주문한 내역이 있어서 탈퇴가 불가능합니다..");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//회원수정 메소드
	public void update(customerDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update customer set cname=?,cmail=?,cphone=? where cnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCmail());
			pstmt.setString(3, dto.getCphone());
			pstmt.setInt(4, dto.getCnum());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<회원정보 수정완료>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<회원정보 수정실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//전체회원 조회 메소드
	public ArrayList<customerDto> selectAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from customer";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<customerDto> list=new ArrayList<customerDto>();
			while(rs.next()) {
				int cnum=rs.getInt("cnum");
				String cname=rs.getString("cname");
				String cmail=rs.getString("cmail");
				String cphone=rs.getString("cphone");
				customerDto dto=new customerDto(cnum, cname, cmail, cphone);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	//회원 조회 메소드
	public ArrayList<customerDto> select(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from customer where cnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<customerDto> list=new ArrayList<customerDto>();
			rs.next();
			int cnum=rs.getInt("cnum");
			String cname=rs.getString("cname");
			String cmail=rs.getString("cmail");
			String cphone=rs.getString("cphone");
			customerDto dto=new customerDto(cnum, cname, cmail, cphone);
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
