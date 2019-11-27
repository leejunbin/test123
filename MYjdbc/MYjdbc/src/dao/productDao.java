package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.productDto;
import jdbc.JdbcUtil;

public class productDao {
	//��ǰ�߰� �޼ҵ�
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
			System.out.println("<<��ǰ��� �Ϸ�!>>");
		}catch(SQLException se) {
			try {
				System.out.println("<<��ǰ��� ����!>>");
				con.rollback();
				System.out.println("�����޽���: " + se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ǰ���� �޼ҵ�
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
			System.out.println("<<��ǰ�����Ϸ�>>");
		}catch(SQLException se) {
			try {
				System.out.println("<<��ǰ���� ����..>>");
				con.rollback();
				System.out.println("�����޽���: " + se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ǰ���� �޼ҵ�
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
			System.out.println("<<��ǰ�����Ϸ�!!>");
			
		}catch(SQLException se) {
			try {
				System.out.println("<<��ǰ��������..>>");
				con.rollback();
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ü��ǰ ������ȸ �޼ҵ�
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
	//��ǰ���� ��ȸ �޼ҵ�
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
			System.out.println("<<�ش�Ǵ� ��ǰ�� �������� �ʽ��ϴ�..>>");
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	//��� �԰�,��� �������ִ� �޼ҵ� 
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
	//�ֹ��� ��ǰ�� �ش��ϴ� ��ǰ�ڵ�,������ �����ϴ� �޼ҵ�
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
