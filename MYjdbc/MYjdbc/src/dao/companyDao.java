package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.companyDto;
import jdbc.JdbcUtil;

public class companyDao {
	//��ü�߰� �޼ҵ�
	public void insert(companyDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="insert into company values(comp_seq.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getComname());
			pstmt.setString(2, dto.getComloc());
			pstmt.setString(3, dto.getComphone());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<��ü��� �Ϸ�!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<��ü��� ����..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ü���� �޼ҵ�
	public void delete(int number) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="delete from company where companycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<��ü�����Ϸ�!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<��ü��Ͻ���..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ü���� �޼ҵ�
	public void update(companyDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update company set comname=?,comloc=?,comphone=? where companycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getComname());
			pstmt.setString(2, dto.getComloc());
			pstmt.setString(3, dto.getComphone());
			pstmt.setInt(4, dto.getCompanycode());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<��ü���� �����Ϸ�!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<��ü���� ��������..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//��ü��ü��ȸ �޼ҵ�
	public ArrayList<companyDto> selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from company";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<companyDto> list=new ArrayList<companyDto>();
			while(rs.next()) {
				int companycode=rs.getInt("companycode");
				String comname=rs.getString("comname");
				String comloc=rs.getString("comloc");
				String comphone=rs.getString("comphone");
				companyDto dto=new companyDto(companycode, comname, comloc, comphone);
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
	//��ü��ȸ �޼ҵ�
	public ArrayList<companyDto> select(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from company where companycode=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<companyDto> list=new ArrayList<companyDto>();
			rs.next();
			int companycode=rs.getInt("companycode");
			String comname=rs.getString("comname");
			String comloc=rs.getString("comloc");
			String comphone=rs.getString("comphone");
			companyDto dto=new companyDto(companycode, comname, comloc, comphone);
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
