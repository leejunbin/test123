package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.companyDao;
import dto.companyDto;

public class companyMethod {
	static Scanner scan=new Scanner(System.in);
	static companyDao cDao=new companyDao();
	//업체등록 메소드
	public static void insert() {
		System.out.println("[업체추가 정보입력]");
		System.out.print("업체명: ");
		String comname=scan.next();
		System.out.print("주소입력: ");
		String comloc=scan.next();
		System.out.print("회사전번: ");
		String comphone=scan.next();
		companyDto dto=new companyDto(0, comname, comloc, comphone);
		cDao.insert(dto);
	}
	//업체삭제 메소드
	public static void delete() {
		System.out.println("[업체삭제 정보입력]");
		System.out.print("삭제할 업체코드: ");
		int companycode=scan.nextInt();
		cDao.delete(companycode);
	}
	//업체수정 메소드
	public static void update() {
		System.out.println("[업체수정 정보입력]");
		System.out.print("수정할 업체코드 입력: ");
		int companycode=scan.nextInt();
		System.out.print("업체명: ");
		String comname=scan.next();
		System.out.print("업체주소: ");
		String comloc=scan.next();
		System.out.print("업체전화번호: ");
		String comphone=scan.next();
		companyDto dto=new companyDto(companycode, comname, comloc, comphone);
		cDao.update(dto);
	}
	//등록업체 전체조회
	public static void selectAll() {
		System.out.println("<<등록업체 전체조회결과>>");
		System.out.println("────────────────────────────────────");
		System.out.println("업체코드\t 업체명\t업체주소\t   업체전화번호");
		System.out.println("────────────────────────────────────");
		ArrayList<companyDto> list=cDao.selectAll();
		for(int i=0;i<list.size();i++) {
			companyDto dto=list.get(i);
			System.out.println(" "+dto.getCompanycode()+"\t" +dto.getComname()+"\t  "+dto.getComloc()
			+"\t"+dto.getComphone());
			System.out.println("────────────────────────────────────");
		}
	}
	//선택된 업체 조회
	public static void select() {
		System.out.print("업체조회할 코드명 입력: ");
		int number=scan.nextInt();
		System.out.println("<<업체조회 결과>>");
		ArrayList<companyDto> list=cDao.select(number);
		companyDto dto=list.get(0);
		if(dto!=null) {
			System.out.println("업체코드: " + dto.getCompanycode());
			System.out.println("업체명: " + dto.getComname());
			System.out.println("업체주소: " + dto.getComloc());
			System.out.println("업체전화번호: " + dto.getComphone());
		}else {
			System.out.println("조회된 결과가 없습니다...");
		}
	}
}
