package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.delDao;
import dto.delDto;

public class delMethod {
	static Scanner scan=new Scanner(System.in);
	static delDao dDao=new delDao();
	static selectComcode com=new selectComcode();
	
	//택배기사 추가메소드
	public static void insert() {
		System.out.println("[택배기사 등록]");
		System.out.print("택배기사코드 입력: ");
		int delcode=scan.nextInt();
		System.out.print("이름입력: ");
		String delname=scan.next();
		System.out.print("전화번호 입력: ");
		String delphone=scan.next();
		System.out.print("이메일입력: ");
		String delmail=scan.next();
		int companycode=com.sendComcode();
		delDto dto=new delDto(delcode, delname, delphone, delmail, companycode);
		dDao.insert(dto);
	}
	//택배기사 삭제 메소드
	public static void delete() {
		System.out.println("[택배기사 삭제]");
		System.out.print("택배기사 코드 입력: ");
		int delcode=scan.nextInt();
		dDao.delete(delcode);
	}
	//택배기사 정보 수정 메소드
	public static void update() {
		System.out.println("[택배기사 정보수정}");
		System.out.print("택배기사코드 입력: ");
		int delcode=scan.nextInt();
		System.out.print("이름입력: ");
		String delname=scan.next();
		System.out.print("전화번호: ");
		String delphone=scan.next();
		System.out.print("이메일: ");
		String delmail=scan.next();
		delDto dto=new delDto(delcode, delname, delphone, delmail,0);
		dDao.update(dto);
	}
	//택배기사 전체 조회
	public static void selectAll() {
		System.out.println("<<택배기사 전체조회결과>>");
		ArrayList<delDto> list=dDao.selectAll();
		System.out.println("─────────────────────────────────────────────────────────────────────");
		System.out.println("택배기사코드       이름\t\t전화번호\t\t  이메일\t\t택배회사 코드번호");
		System.out.println("─────────────────────────────────────────────────────────────────────");
		for(int i=0;i<list.size();i++) {
			delDto dto=list.get(i);
			System.out.println("  "+dto.getDelcode()+"\t     "+dto.getDelname()+"\t    "+dto.getDelphone()+"     "
					+dto.getDelmail()+"\t    "+dto.getCompanycode());
			System.out.println("─────────────────────────────────────────────────────────────────────");
		}
	}
	//택배기사 찾기 메소드
	public static void select() {
		System.out.println("[택배기사 조회]");
		System.out.print("조회하려는 택배기사 코드 입력: ");
		int delcode=scan.nextInt();
		System.out.println("<<택배기사 검색결과>>");
		ArrayList<delDto> list=dDao.select(delcode);
		delDto dto=list.get(0);
		System.out.println("택배기사 코드: " + dto.getDelcode());
		System.out.println("택배기사 이름: " + dto.getDelname());
		System.out.println("택배기사 전화번호: " +dto.getDelphone());
		System.out.println("택배기사 이메일: " + dto.getDelmail());
		System.out.println("택배회사 코드번호: " + dto.getCompanycode());
	}
}
