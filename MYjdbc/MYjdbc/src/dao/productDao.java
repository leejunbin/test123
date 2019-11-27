package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.productDto;
import jdbc.JdbcUtil;

public class productDao {
	//물품추가 메소드
	public void insert(productDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="insert into buyproduct values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBuycode());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getColor());
			pstmt.setInt(5, dto.getInven());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<물품등록 완료!>>");
		}catch(SQLException se) {
			try {
				System.out.println("<<물품등록 실패!>>");
				con.rollback();
				System.out.println("오류메시지: " + se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//물품삭제 메소드
	public void delete(int number) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="delete from buyproduct where buycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<물품삭제완료>>");
		}catch(SQLException se) {
			try {
				System.out.println("<<물품삭제 실패..>>");
				con.rollback();
				System.out.println("오류메시지: " + se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//물품수정 메소드
	public void update(productDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update buyproduct set pname=?,price=?,color=?,inven=? where buycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getColor());
			pstmt.setInt(4, dto.getBuycode());
			pstmt.setInt(5, dto.getInven());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<물품수정완료!!>");
			
		}catch(SQLException se) {
			try {
				System.out.println("<<물품수정실패..>>");
				con.rollback();
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//전체물품 정보조회 메소드
	public ArrayList<productDto> selectAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from buyproduct";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<productDto> list=new ArrayList<productDto>();
			while(rs.next()) {
				int buycode=rs.getInt("buycode");
				String pname=rs.getString("pname");
				int price=rs.getInt("price");
				String color=rs.getString("color");
				int inven=rs.getInt("inven");
				productDto dto=new productDto(buycode, pname, price, color,inven);
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
	//물품정보 조회 메소드
	public ArrayList<productDto> select(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from buyproduct where buycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<productDto> list=new ArrayList<productDto>();
			rs.next();
			int buycode=rs.getInt("buycode");
			String pname=rs.getString("pname");
			int price=rs.getInt("price");
			String color=rs.getString("color");
			int inven=rs.getInt("inven");
			productDto dto=new productDto(buycode, pname, price, color,inven);
			list.add(dto);
			return list;
		}catch(SQLException se) {
			System.out.println("<<해당되는 제품이 존재하지 않습니다..>>");
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	//재고 입고,출고를 변경해주는 메소드 
	public int invenUpdate(productDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update buyproduct set inven=? where buycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getInven());
			pstmt.setInt(2, dto.getBuycode());
			pstmt.executeUpdate();
			con.commit();
			
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println(se.getMessage());
				return -1;
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
		return 1;
	}
	//주문한 물품에 해당하는 물품코드,재고수량 전달하는 메소드
	public ArrayList<productDto> sendInven(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select buycode,inven from buyproduct where buycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<productDto> list=new ArrayList<productDto>();
			rs.next();
			int buycode=rs.getInt("buycode");
			int inven=rs.getInt("inven");
			productDto dto=new productDto(buycode, inven);
			list.add(dto);
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	
	
	
}
