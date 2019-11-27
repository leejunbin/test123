package myproject;

import java.util.Scanner;

import dao.productDao;

public class myproject {
	static Scanner scan=new Scanner(System.in);
	static productDao pDao=new productDao(); //물품정보에 대한 DAO
	public static void main(String[] args) {
		String id="";
		String pwd="";
		System.out.println("         ┌───────────────────────────────────────┐");
		System.out.println("         │\t중앙HTA 쇼핑몰에 오신걸 환영합니다!! \t │");
		System.out.println("         └───────────────────────────────────────┘");
		System.out.print("\t #####   #######    #      #####    ####### \n");
		System.out.print("\t#           #      # #     #    #      #    \n");
		System.out.print("\t#####       #     #####    ######      #    \n");
		System.out.print("\t     #      #    #     #   #     #     #    \n");
		System.out.print("\t#####       #   #       #  #     #     #    \n\n");
		System.out.println("	1.회원모드     2.쇼핑몰관리자모드\t3.택배업체관리자모드");
		int modeNum=scan.nextInt();
		//관리자모드 등록시
		if(modeNum==2) {
			System.out.print("┌──관리자 아이디입력──┐\n");
			System.out.print("│☞");
			id=scan.next();
			System.out.print("┌──비밀번호입력──┐\n");
			System.out.print("│☞");
			pwd=scan.next();
			if(id.equals("admin") && pwd.equals("1234")) {
				System.out.println("<<관리자 접속성공!!>>\n");
			}else {
				System.out.println("아이디 및 비밀번호가 일치하지 않습니다..");
				System.exit(0); //종료
			}
			while(true) {
				boolean find=false;
				System.out.println("=======================메뉴를 선택=======================");
				System.out.println("1.고객관련		2.주문관련		3.물품관련		4.종료");
				int num=scan.nextInt();
				switch(num) {
				case 1:
					System.out.println("===============메뉴를 선택================");
					System.out.println("a.가입회원 전체목록       b.주문전체 목록       c.뒤로가기");
					char editNum2=scan.next().charAt(0);
					switch(editNum2) {
					case 'A':
					case 'a': customMethod.selectAll();break;
					case 'B':
					case 'b': orderMethod.selectAll(); break;
					case 'C':
					case 'c': continue;
					}
					break;
				case 2:
					System.out.println("=================메뉴를 선택=================");
					System.out.println("a.주문전체조회  b.뒤로가기");
					char editNum1=scan.next().charAt(0); //문자하나 받기
					switch(editNum1) {
					case 'A':
					case 'a': orderMethod.selectAll(); break;
					case 'B':
					case 'b': continue;
					}
				break;
				case 3:
					System.out.println("======================메뉴를 선택=====================");
					System.out.println("a.물품추가  b.물품삭제 c.물품수정 d.전체물품조회 e.물품검색 f.뒤로가기");
					char editNum=scan.next().charAt(0); //문자하나 받기
					switch(editNum) {
					case 'A':
					case 'a': productMethod.insert();break;
					case 'B':
					case 'b': productMethod.delete();break;
					case 'C':
					case 'c': productMethod.update();break;
					case 'D':
					case 'd': productMethod.selectAll_1(); break;
					case 'E':
					case 'e': productMethod.select();break;
					case 'F':
					case 'f': continue;
					}
					break;
				case 4: 
					System.out.println("종료합니다...");
					find=true;
					break;
				}
				if(find) break; //종료
			}
		}else if(modeNum==3) {
			System.out.print("┌──관리자 아이디입력──┐\n");
			System.out.print("│☞");
			id=scan.next();
			System.out.print("┌──비밀번호입력──┐\n");
			System.out.print("│☞");
			pwd=scan.next();
			if(id.equals("admin") && pwd.equals("1234")) {
				System.out.println("<<택배회사관리자 접속성공!!>>\n");
			}else {
				System.out.println("아이디 및 비밀번호가 일치하지 않습니다..");
				System.exit(0); //종료
			}
			while(true) {
				boolean find=false;
				System.out.println("=================메뉴를 선택=================");
				System.out.println("1.택배업체명관련\t2.택배기사관련\t3.종료");
				int delNum=scan.nextInt();
				switch(delNum) {
				case 1:
					System.out.println("=======================메뉴를 선택=======================");
					System.out.println("a.업체등록 b.업체삭제 c.업체수정 d.등록업체전체조회 e.업체찾기 f.뒤로가기");
					char editNum=scan.next().charAt(0); //문자하나 받기
					switch(editNum) {
					case 'A':
					case 'a': companyMethod.insert(); break;
					case 'B':
					case 'b': companyMethod.delete(); break;
					case 'C':
					case 'c': companyMethod.update(); break;
					case 'D':
					case 'd': companyMethod.selectAll(); break;
					case 'E':
					case 'e': companyMethod.select(); break;
					case 'F':
					case 'f': continue;
					}
					break;
				case 2:
					System.out.println("=============================메뉴를 선택=============================");
					System.out.println("a.택배기사등록 b.택배기사삭제 c.택배기사정보수정 d.등록된기사 전체조회 e.기사찾기 f.뒤로가기");
					char editNum1=scan.next().charAt(0); //문자하나 받기
					switch(editNum1) {
					case 'A':
					case 'a': delMethod.insert(); break;
					case 'B':
					case 'b': delMethod.delete(); break;
					case 'C':
					case 'c': delMethod.update(); break;
					case 'D':
					case 'd': delMethod.selectAll(); break;
					case 'E':
					case 'e': delMethod.select(); break;
					case 'F':
					case 'f': continue;
					}
					break;
				case 3:
					System.out.println("종료합니다..");
					find=true;
					break;
				}
				if(find) break;
			}
		}else if(modeNum==1) { //회원모드 동작
			while(true) {
				boolean find=false;
				System.out.println("=================메뉴를 선택=================");
				System.out.println("1.회원가입메뉴\t 2.물품주문\t 3.종료");
				int num=scan.nextInt();
				switch(num){
				case 1:
					System.out.println("=================메뉴를 선택=================");
					System.out.println("a.회원가입 b.회원탈퇴 c.회원정보수정 f.뒤로가기");
					char editNum=scan.next().charAt(0); //문자하나 받기
					switch(editNum) {
					case 'A':
					case 'a': customMethod.insert(); break;
					case 'B':
					case 'b': customMethod.delete(); break;
					case 'C':
					case 'c': customMethod.update(); break;
					case 'F':
					case 'f': continue;
					}
				case 2:
					System.out.println("=================메뉴를 선택=================");
					System.out.println("a.물품주문 b.주문취소 c.주문수정 d.주문조회 f.뒤로가기");
					char editNum1=scan.next().charAt(0); //문자하나 받기
					switch(editNum1) {
					case 'A':
					case 'a': orderMethod.insert(); break;
					case 'B':
					case 'b': orderMethod.delete(); break;
					case 'C':
					case 'c': orderMethod.update(); break;
					case 'D':
					case 'd': orderMethod.select(); break;
					}
					break;
				case 3:
					System.out.println("종료합니다..");
					find=true;
					break;
				}
				if(find) break;
			}
		}
	}
}





