package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.customerDao;
import dto.customerDto;

public class customMethod {
	static Scanner scan=new Scanner(System.in);
	static customerDao cDao=new customerDao();
	
	//ȸ���߰� �޼ҵ�
	public static void insert() {
		System.out.println("[ȸ���߰�]");
		System.out.print("ȸ���̸� �Է�: ");
		String cname=scan.next();
		System.out.print("ȸ�� �̸��� �Է�: ");
		String cmail=scan.next();
		System.out.print("ȸ�� ��ȭ��ȣ �Է�: ");
		String cphone=scan.next();
		customerDto dto=new customerDto(0, cname, cmail, cphone);
		cDao.insert(dto);
	}
	//ȸ��Ż�� �޼ҵ�
	public static void delete() {
		System.out.println("[ȸ��Ż��]");
		System.out.print("������ ȸ����ȣ �Է�: ");
		int cnum=scan.nextInt();
		cDao.delete(cnum);
	}
	//ȸ������ �޼ҵ�
	public static void update() {
		System.out.println("[ȸ������]");
		System.out.print("������ ȸ����ȣ �Է�: ");
		int cnum=scan.nextInt();
		System.out.print("�̸��Է�: ");
		String cname=scan.next();
		System.out.print("�̸����Է�: ");
		String cmail=scan.next();
		System.out.print("��ȭ��ȣ �Է�: ");
		String cphone=scan.next();
		customerDto dto=new customerDto(cnum, cname, cmail, cphone);
		cDao.update(dto);
	}
	//��üȸ�� �����ȸ �޼ҵ�
	public static void selectAll() {
		System.out.println("<<��üȸ�����>>");
		ArrayList<customerDto> list=cDao.selectAll();
		System.out.println("ȸ����ȣ\tȸ���̸�\t     ȸ���̸���\t       �޴�����ȣ");
		System.out.println("��������������������������������������������������������������������������������������������");
		for(int i=0;i<list.size();i++) {
			customerDto dto=list.get(i);
			System.out.println(dto.getCnum() + "\t" + dto.getCname() + "\t" + dto.getCmail() + "\t" + dto.getCphone());
		}
		System.out.println();
	}
	
}
