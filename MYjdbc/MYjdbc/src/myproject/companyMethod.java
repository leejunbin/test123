package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.companyDao;
import dto.companyDto;

public class companyMethod {
	static Scanner scan=new Scanner(System.in);
	static companyDao cDao=new companyDao();
	//��ü��� �޼ҵ�
	public static void insert() {
		System.out.println("[��ü�߰� �����Է�]");
		System.out.print("��ü��: ");
		String comname=scan.next();
		System.out.print("�ּ��Է�: ");
		String comloc=scan.next();
		System.out.print("ȸ������: ");
		String comphone=scan.next();
		companyDto dto=new companyDto(0, comname, comloc, comphone);
		cDao.insert(dto);
	}
	//��ü���� �޼ҵ�
	public static void delete() {
		System.out.println("[��ü���� �����Է�]");
		System.out.print("������ ��ü�ڵ�: ");
		int companycode=scan.nextInt();
		cDao.delete(companycode);
	}
	//��ü���� �޼ҵ�
	public static void update() {
		System.out.println("[��ü���� �����Է�]");
		System.out.print("������ ��ü�ڵ� �Է�: ");
		int companycode=scan.nextInt();
		System.out.print("��ü��: ");
		String comname=scan.next();
		System.out.print("��ü�ּ�: ");
		String comloc=scan.next();
		System.out.print("��ü��ȭ��ȣ: ");
		String comphone=scan.next();
		companyDto dto=new companyDto(companycode, comname, comloc, comphone);
		cDao.update(dto);
	}
	//��Ͼ�ü ��ü��ȸ
	public static void selectAll() {
		System.out.println("<<��Ͼ�ü ��ü��ȸ���>>");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("��ü�ڵ�\t ��ü��\t��ü�ּ�\t   ��ü��ȭ��ȣ");
		System.out.println("������������������������������������������������������������������������");
		ArrayList<companyDto> list=cDao.selectAll();
		for(int i=0;i<list.size();i++) {
			companyDto dto=list.get(i);
			System.out.println(" "+dto.getCompanycode()+"\t" +dto.getComname()+"\t  "+dto.getComloc()
			+"\t"+dto.getComphone());
			System.out.println("������������������������������������������������������������������������");
		}
	}
	//���õ� ��ü ��ȸ
	public static void select() {
		System.out.print("��ü��ȸ�� �ڵ�� �Է�: ");
		int number=scan.nextInt();
		System.out.println("<<��ü��ȸ ���>>");
		ArrayList<companyDto> list=cDao.select(number);
		companyDto dto=list.get(0);
		if(dto!=null) {
			System.out.println("��ü�ڵ�: " + dto.getCompanycode());
			System.out.println("��ü��: " + dto.getComname());
			System.out.println("��ü�ּ�: " + dto.getComloc());
			System.out.println("��ü��ȭ��ȣ: " + dto.getComphone());
		}else {
			System.out.println("��ȸ�� ����� �����ϴ�...");
		}
	}
}
