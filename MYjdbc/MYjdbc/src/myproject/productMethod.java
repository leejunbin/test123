package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.productDao;
import dto.productDto;

public class productMethod {
	static Scanner scan=new Scanner(System.in);
	static productDao pDao=new productDao();
	//물품전체조회 메소드
	public static void selectAll() {
		System.out.println("<<물품전체 조회결과>>");
		ArrayList<productDto> list=pDao.selectAll();
		for(int i=0;i<list.size();i++) {
			productDto dto=list.get(i);
			System.out.println("물품코드: " + dto.getBuycode());
			System.out.println("물품명: " + dto.getPname());
			System.out.println("가격: " + dto.getPrice()+"원");
			System.out.println("색상: " + dto.getColor());
			System.out.println("재고수량: " + dto.getInven()+"개");
			System.out.println("================");
		}
	}
	//물품전체조회 메소드(버전2)
		public static void selectAll_1() {
			ArrayList<productDto> list=pDao.selectAll();
			System.out.println("==============물품정보==================");
			System.out.println("──────────────────────────────────────");
			System.out.println("물품코드\t물품명\t가격\t색상\t재고수량");
			System.out.println("──────────────────────────────────────");
			for(int i=0;i<list.size();i++) {
				productDto dto=list.get(i);
				System.out.println(dto.getBuycode()+"\t" +dto.getPname() +"\t" + dto.getPrice() +"\t" +dto.getColor()+"\t"+dto.getInven()+"개");
				System.out.println("──────────────────────────────────────");
			}
		}
	//물품추가 메소드
	public static void insert() {
		System.out.println("[추가할 물품정보 입력]");
		System.out.print("물품코드: ");
		int buycode=scan.nextInt();
		System.out.print("물품명: ");
		String pname=scan.next();
		System.out.print("가격: ");
		int price=scan.nextInt();
		System.out.print("색상: ");
		String color=scan.next();
		System.out.print("입고수량: ");
		int inven=scan.nextInt(); 
		productDto dto=new productDto(buycode, pname, price, color,inven);
		pDao.insert(dto); //추가메소드 호출
	}
	//물품삭제 메소드
	public static void delete() {
		System.out.print("삭제할 물품번호 입력: ");
		int num=scan.nextInt();
		pDao.delete(num); //삭제메소드 호출
	}
	//물품수정 메소드
	public static void update() {
		System.out.println("[수정할 물품정보 입력]");
		System.out.print("물품코드 :");
		int buycode=scan.nextInt();
		System.out.print("물품명: ");
		String pname=scan.next();
		System.out.print("가격: ");
		int price=scan.nextInt();
		System.out.print("색상: ");
		String color=scan.next();
		System.out.println("재고수량: ");
		int inven=scan.nextInt();
		productDto dto=new productDto(buycode, pname, price, color,inven);
		pDao.update(dto); //수정메소드 호출
	}
	//물품조회(검색) 메소드 
	public static void select() {
		System.out.print("조회하려는 물품코드를 입력: ");
		int number=scan.nextInt();
		System.out.println("<<물품조회 결과>>");
		ArrayList<productDto> list=pDao.select(number);
		productDto dto=list.get(0);
		if(dto!=null) {
			System.out.println("물품코드: " + dto.getBuycode());
			System.out.println("물품명: " + dto.getPname());
			System.out.println("가격: " + dto.getPrice()+"원");
			System.out.println("색상: " + dto.getColor());
			System.out.println("재고수량: " + dto.getInven()+"개");
		}else {
			System.out.println("조회한 물품이 없습니다...");
		}
	}
}
