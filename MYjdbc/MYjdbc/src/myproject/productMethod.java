package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.productDao;
import dto.productDto;

public class productMethod {
	static Scanner scan=new Scanner(System.in);
	static productDao pDao=new productDao();
	//��ǰ��ü��ȸ �޼ҵ�
	public static void selectAll() {
		System.out.println("<<��ǰ��ü ��ȸ���>>");
		ArrayList<productDto> list=pDao.selectAll();
		for(int i=0;i<list.size();i++) {
			productDto dto=list.get(i);
			System.out.println("��ǰ�ڵ�: " + dto.getBuycode());
			System.out.println("��ǰ��: " + dto.getPname());
			System.out.println("����: " + dto.getPrice()+"��");
			System.out.println("����: " + dto.getColor());
			System.out.println("������: " + dto.getInven()+"��");
			System.out.println("================");
		}
	}
	//��ǰ��ü��ȸ �޼ҵ�(����2)
		public static void selectAll_1() {
			ArrayList<productDto> list=pDao.selectAll();
			System.out.println("==============��ǰ����==================");
			System.out.println("����������������������������������������������������������������������������");
			System.out.println("��ǰ�ڵ�\t��ǰ��\t����\t����\t������");
			System.out.println("����������������������������������������������������������������������������");
			for(int i=0;i<list.size();i++) {
				productDto dto=list.get(i);
				System.out.println(dto.getBuycode()+"\t" +dto.getPname() +"\t" + dto.getPrice() +"\t" +dto.getColor()+"\t"+dto.getInven()+"��");
				System.out.println("����������������������������������������������������������������������������");
			}
		}
	//��ǰ�߰� �޼ҵ�
	public static void insert() {
		System.out.println("[�߰��� ��ǰ���� �Է�]");
		System.out.print("��ǰ�ڵ�: ");
		int buycode=scan.nextInt();
		System.out.print("��ǰ��: ");
		String pname=scan.next();
		System.out.print("����: ");
		int price=scan.nextInt();
		System.out.print("����: ");
		String color=scan.next();
		System.out.print("�԰����: ");
		int inven=scan.nextInt(); 
		productDto dto=new productDto(buycode, pname, price, color,inven);
		pDao.insert(dto); //�߰��޼ҵ� ȣ��
	}
	//��ǰ���� �޼ҵ�
	public static void delete() {
		System.out.print("������ ��ǰ��ȣ �Է�: ");
		int num=scan.nextInt();
		pDao.delete(num); //�����޼ҵ� ȣ��
	}
	//��ǰ���� �޼ҵ�
	public static void update() {
		System.out.println("[������ ��ǰ���� �Է�]");
		System.out.print("��ǰ�ڵ� :");
		int buycode=scan.nextInt();
		System.out.print("��ǰ��: ");
		String pname=scan.next();
		System.out.print("����: ");
		int price=scan.nextInt();
		System.out.print("����: ");
		String color=scan.next();
		System.out.println("������: ");
		int inven=scan.nextInt();
		productDto dto=new productDto(buycode, pname, price, color,inven);
		pDao.update(dto); //�����޼ҵ� ȣ��
	}
	//��ǰ��ȸ(�˻�) �޼ҵ� 
	public static void select() {
		System.out.print("��ȸ�Ϸ��� ��ǰ�ڵ带 �Է�: ");
		int number=scan.nextInt();
		System.out.println("<<��ǰ��ȸ ���>>");
		ArrayList<productDto> list=pDao.select(number);
		productDto dto=list.get(0);
		if(dto!=null) {
			System.out.println("��ǰ�ڵ�: " + dto.getBuycode());
			System.out.println("��ǰ��: " + dto.getPname());
			System.out.println("����: " + dto.getPrice()+"��");
			System.out.println("����: " + dto.getColor());
			System.out.println("������: " + dto.getInven()+"��");
		}else {
			System.out.println("��ȸ�� ��ǰ�� �����ϴ�...");
		}
	}
}
