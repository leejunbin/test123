package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.delDto;
import jdbc.JdbcUtil;

public class delDao {
	//�ù��� �߰��޼ҵ�
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
			System.out.println("<<�ù��� ��ϿϷ�!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<�ù��� ��Ͻ���..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//�ù��� �����޼ҵ�
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
			System.out.println("<<�ù��� �����Ϸ�>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<�ù��� ��������..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//�ù��� �����޼ҵ�
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
			System.out.println("<<�ù��� �������� �Ϸ�!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<�������� ����..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	//�ù��� ��ü��ȸ
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
	//�ù��� �˻� �޼ҵ�
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
