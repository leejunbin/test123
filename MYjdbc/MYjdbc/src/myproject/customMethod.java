package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.customerDao;
import dto.customerDto;

public class customMethod {
	static Scanner scan=new Scanner(System.in);
	static customerDao cDao=new customerDao();
	
	//회원추가 메소드
	public static void insert() {
		System.out.println("[회원추가]");
		System.out.print("회원이름 입력: ");
		String cname=scan.next();
		System.out.print("회원 이메일 입력: ");
		String cmail=scan.next();
		System.out.print("회원 전화번호 입력: ");
		String cphone=scan.next();
		customerDto dto=new customerDto(0, cname, cmail, cphone);
		cDao.insert(dto);
	}
	//회원탈퇴 메소드
	public static void delete() {
		System.out.println("[회원탈퇴]");
		System.out.print("삭제할 회원번호 입력: ");
		int cnum=scan.nextInt();
		cDao.delete(cnum);
	}
	//회원수정 메소드
	public static void update() {
		System.out.println("[회원수정]");
		System.out.print("수정할 회원번호 입력: ");
		int cnum=scan.nextInt();
		System.out.print("이름입력: ");
		String cname=scan.next();
		System.out.print("이메일입력: ");
		String cmail=scan.next();
		System.out.print("전화번호 입력: ");
		String cphone=scan.next();
		customerDto dto=new customerDto(cnum, cname, cmail, cphone);
		cDao.update(dto);
	}
	//전체회원 목록조회 메소드
	public static void selectAll() {
		System.out.println("<<전체회원목록>>");
		ArrayList<customerDto> list=cDao.selectAll();
		System.out.println("회원번호\t회원이름\t     회원이메일\t       휴대폰번호");
		System.out.println("──────────────────────────────────────────────");
		for(int i=0;i<list.size();i++) {
			customerDto dto=list.get(i);
			System.out.println(dto.getCnum() + "\t" + dto.getCname() + "\t" + dto.getCmail() + "\t" + dto.getCphone());
		}
		System.out.println();
	}
	
}
