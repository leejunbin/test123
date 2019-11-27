package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import jdbc.JdbcUtil;

public class selectComcode {
	static Scanner scan=new Scanner(System.in);
	static Random rnd=new Random();
	//택배회사코드 리턴해주는 메소드
	public int sendComcode() {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from company";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int cnt=0;
			int i=0;
			while(rs.next()) {
				cnt++;
			}
			//rs.close();
			//pstmt.close();
			pstmt1=con.prepareStatement(sql);
			rs1=pstmt1.executeQuery();
			int[] a=new int[cnt];
			while(rs1.next()) {
				a[i]=rs1.getInt("companycode");
				i++;
			}
			//rs1.close();
			//pstmt1.close();
			int rNum=rnd.nextInt(cnt);
			int reNum=a[rNum];
			return reNum;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
			JdbcUtil.close(null,pstmt1,rs1);
		}
	}
	//택배기사 코드 리턴해주는 메소드
	public int sendDelcode() {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from delinfo";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int cnt=0;
			int i=0;
			while(rs.next()) {
				cnt++;
			}
			pstmt1=con.prepareStatement(sql);
			rs1=pstmt1.executeQuery();
			int[] a=new int[cnt];
			while(rs1.next()) {
				a[i]=rs1.getInt("delcode");
				i++;
			}
			int rNum=rnd.nextInt(cnt);
			int reNum=a[rNum];
			return reNum;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
			JdbcUtil.close(null,pstmt1,rs1);
		}
	}
	
}
