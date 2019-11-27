package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.delDao;
import dto.delDto;

public class delMethod {
	static Scanner scan=new Scanner(System.in);
	static delDao dDao=new delDao();
	static selectComcode com=new selectComcode();
	
	//�ù��� �߰��޼ҵ�
	public static void insert() {
		System.out.println("[�ù��� ���]");
		System.out.print("�ù����ڵ� �Է�: ");
		int delcode=scan.nextInt();
		System.out.print("�̸��Է�: ");
		String delname=scan.next();
		System.out.print("��ȭ��ȣ �Է�: ");
		String delphone=scan.next();
		System.out.print("�̸����Է�: ");
		String delmail=scan.next();
		int companycode=com.sendComcode();
		delDto dto=new delDto(delcode, delname, delphone, delmail, companycode);
		dDao.insert(dto);
	}
	//�ù��� ���� �޼ҵ�
	public static void delete() {
		System.out.println("[�ù��� ����]");
		System.out.print("�ù��� �ڵ� �Է�: ");
		int delcode=scan.nextInt();
		dDao.delete(delcode);
	}
	//�ù��� ���� ���� �޼ҵ�
	public static void update() {
		System.out.println("[�ù��� ��������}");
		System.out.print("�ù����ڵ� �Է�: ");
		int delcode=scan.nextInt();
		System.out.print("�̸��Է�: ");
		String delname=scan.next();
		System.out.print("��ȭ��ȣ: ");
		String delphone=scan.next();
		System.out.print("�̸���: ");
		String delmail=scan.next();
		delDto dto=new delDto(delcode, delname, delphone, delmail,0);
		dDao.update(dto);
	}
	//�ù��� ��ü ��ȸ
	public static void selectAll() {
		System.out.println("<<�ù��� ��ü��ȸ���>>");
		ArrayList<delDto> list=dDao.selectAll();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�ù����ڵ�       �̸�\t\t��ȭ��ȣ\t\t  �̸���\t\t�ù�ȸ�� �ڵ��ȣ");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
		for(int i=0;i<list.size();i++) {
			delDto dto=list.get(i);
			System.out.println("  "+dto.getDelcode()+"\t     "+dto.getDelname()+"\t    "+dto.getDelphone()+"     "
					+dto.getDelmail()+"\t    "+dto.getCompanycode());
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
		}
	}
	//�ù��� ã�� �޼ҵ�
	public static void select() {
		System.out.println("[�ù��� ��ȸ]");
		System.out.print("��ȸ�Ϸ��� �ù��� �ڵ� �Է�: ");
		int delcode=scan.nextInt();
		System.out.println("<<�ù��� �˻����>>");
		ArrayList<delDto> list=dDao.select(delcode);
		delDto dto=list.get(0);
		System.out.println("�ù��� �ڵ�: " + dto.getDelcode());
		System.out.println("�ù��� �̸�: " + dto.getDelname());
		System.out.println("�ù��� ��ȭ��ȣ: " +dto.getDelphone());
		System.out.println("�ù��� �̸���: " + dto.getDelmail());
		System.out.println("�ù�ȸ�� �ڵ��ȣ: " + dto.getCompanycode());
	}
}
