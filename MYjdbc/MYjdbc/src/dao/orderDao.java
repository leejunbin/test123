package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.orderDto;
import dto.productDto;
import jdbc.JdbcUtil;

public class orderDao {
	productDao pDao=new productDao();
	//주문추가 메소드
	public void insert(orderDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="insert into myorder values(myorder_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBuyamount());
			pstmt.setInt(2, dto.getSumprice());
			pstmt.setString(3, dto.getBuyway());
			pstmt.setInt(4, dto.getCnum());
			pstmt.setInt(5, dto.getBuycode());
			pstmt.setInt(6, dto.getDelcode());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<주문완료!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<주문실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//주문전체내역 조회
	public ArrayList<orderDto> selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from myorder";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<orderDto> list=new ArrayList<orderDto>();
			while(rs.next()) {
				int ordernum=rs.getInt("ordernum");
				int buyamount=rs.getInt("buyamount");
				int sumprice=rs.getInt("sumprice");
				String buyway=rs.getString("buyway");
				int cnum=rs.getInt("cnum");
				int buycode=rs.getInt("buycode");
				int delcode=rs.getInt("delcode");
				orderDto dto=new orderDto(ordernum, buyamount, sumprice, buyway, cnum, buycode, delcode);
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
	//회원이 주문한 내역 조회메소드(조인)
	public ArrayList<orderDto> select(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select o.ordernum,c.cname,b.pname,o.buyamount,o.sumprice,d.delname,d.delphone\r\n" + 
					"from myorder o,customer c,buyproduct b,delinfo d\r\n" + 
					"where o.cnum=c.cnum and o.buycode=b.buycode and o.delcode=d.delcode and c.cnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<orderDto> list=new ArrayList<orderDto>();
			while(rs.next()) {
				int ordernum=rs.getInt("ordernum");
				String cname=rs.getString("cname");
				String pname=rs.getString("pname");
				int buyamount=rs.getInt("buyamount");
				int sumprice=rs.getInt("sumprice");
				String delname=rs.getString("delname");
				String delphone=rs.getString("delphone");
				orderDto dto=new orderDto(ordernum, cname, pname,buyamount,sumprice, delname, delphone);
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
	//주문취소 메소드
	public void delete(int number) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="delete from myorder where ordernum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<주문취소가 완료되었습니다!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<주문취소 오류..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	//주문수정 메소드
	public void update(orderDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			con.setAutoCommit(false);
			String sql="update myorder set buyamount=?,sumprice=?,buyway=?,cnum=?,buycode=? where ordernum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBuyamount());
			pstmt.setInt(2, dto.getSumprice());
			pstmt.setString(3, dto.getBuyway());
			pstmt.setInt(4, dto.getCnum());
			pstmt.setInt(5, dto.getBuycode());
			pstmt.setInt(6, dto.getOrdernum());
			pstmt.executeUpdate();
			con.commit();
			System.out.println("<<주문정보 수정완료!!>>");
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("<<주문정보 수정실패..>>");
				System.out.println(se.getMessage());
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	//주문갯수와 재고 비교해서 구입 가능한지 판별해주는 메소드
	public boolean isInven(int buyCode,int orderNum) {
		boolean find=false;
		ArrayList<productDto> list=pDao.sendInven(buyCode);
		productDto dto=list.get(0);
		int inven=dto.getInven(); //재고수량
		if(orderNum-inven>0) {
			find=true;
		}
		return find;
	}
	//주문번호를 전달받아 제품번호,구매수량을 리턴해주는 메소드 
	public ArrayList<orderDto> sendAmount(int number){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select buyamount,buycode from myorder where ordernum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs=pstmt.executeQuery();
			ArrayList<orderDto> list=new ArrayList<orderDto>();
			rs.next();
			int buyamount=rs.getInt("buyamount");
			int buycode=rs.getInt("buycode");
			orderDto dto=new orderDto(buyamount,buycode);
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
