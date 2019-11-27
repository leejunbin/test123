package myproject;

import java.util.ArrayList;
import java.util.Scanner;

import dao.customerDao;
import dao.orderDao;
import dao.productDao;
import dto.customerDto;
import dto.orderDto;
import dto.productDto;

public class orderMethod {
	static Scanner scan=new Scanner(System.in);
	static orderDao oDao=new orderDao();
	static productDao pDao=new productDao();
	static selectComcode com=new selectComcode();
	static customerDao ccDao=new customerDao();
	
	//�ֹ��߰� �޼ҵ�
	public static void insert() {
		boolean find=false;
		int buyamount;
		System.out.println("[�ֹ��߰�]");
		System.out.print("����ȣ �Է�: ");
		int cnum=scan.nextInt();
		productMethod.selectAll_1(); //��ǰ���� ���
		System.out.print("����� �����ڵ� �Է�: ");
		int buycode=scan.nextInt();
		ArrayList<productDto> list=pDao.select(buycode);
		productDto dto=list.get(0);
		while(true) {
			System.out.print("�����Է�: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<�ֹ��Ͻ� ������ ��� �����մϴ�..>>");
				continue;
			}
			break;
		}
		int sumprice=buyamount * dto.getPrice(); //�Ѱ����ݾ�
		System.out.print("�������� �Է�: ");
		String buyway=scan.next();
		int delcode=com.sendDelcode(); //�ù��� �ڵ� ������ �޾ƿ���
		orderDto oDto=new orderDto(0, buyamount, sumprice, buyway, cnum, buycode,delcode);
		oDao.insert(oDto);
		int updateInven=dto.getInven()-buyamount; //�ֹ�ó���� ���� �����
		productDto updateDto=new productDto(buycode, updateInven);
		pDao.invenUpdate(updateDto); //�ֹ��ϰ� ���� ��� ���̺� ������Ʈ ���ֱ�
	}
	//�ֹ���ü��ȸ �޼ҵ�
	public static void selectAll() {
		System.out.println("<<��ü�ֹ����� ��ȸ>>");
		ArrayList<orderDto> list=oDao.selectAll();
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		System.out.println("�ֹ���ȣ\t�ֹ�����\t�Ѱ�����\t��������\tȸ���ڵ�\t��ǰ�ڵ�\t�ù����ڵ�");
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		for(int i=0;i<list.size();i++) {
			orderDto dto=list.get(i);
			System.out.println("  "+dto.getOrdernum()+"\t  "+dto.getBuyamount()+"��\t"+dto.getSumprice()+"��\t  "+dto.getBuyway()
			+"\t  "+dto.getCnum()+"\t "+dto.getBuycode()+"\t   "+dto.getDelcode());
			System.out.println("����������������������������������������������������������������������������������������������������������������");
		}
	}
	//������ �ֹ��� ȸ����ȸ --���μӼ� �̿�
	public static void select() {
		System.out.println("[ȸ���ֹ�����]");
		System.out.print("ȸ���� �ڵ��Է�: ");
		int cnum=scan.nextInt();
		System.out.println("<<��ǰ�ֹ� ��������Ʈ>>");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�ֹ���ȣ\t���̸�\t�ֹ���ǰ\t�ֹ�����\t�Ѱ����ݾ�\t�ù��� �̸�       �ù��� ����ó");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
				+"��\t"+dto.getSumprice()+"��\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			}
		}else {
			System.out.println("<<�ֹ��� ������ �����ϴ�..>>");
		}
	}
	//�ֹ� ��� �޼ҵ�
	public static void delete() {
		showorder();// ������ �ֹ��� ���� Ȯ���ϴ� �޼ҵ� ȣ��
		System.out.print("����Ϸ���  �ֹ���ȣ�� �Է�: ");
		int delcNum=scan.nextInt();
		ArrayList<orderDto> olist=oDao.sendAmount(delcNum);
		orderDto odto=olist.get(0);
		int buycode=odto.getBuycode();
		ArrayList<productDto> list=pDao.sendInven(buycode);
		productDto dto=list.get(0);
		int delInven=dto.getInven();//�ֹ��� ��ǰ�� ������
		ArrayList<orderDto> list1=oDao.sendAmount(delcNum);
		orderDto dto1=list1.get(0);
		int sendAmount=dto1.getBuyamount();//�ֹ�����Ϸ��� ���ż���
		int sendBuycode=dto1.getBuycode();//�ֹ�����Ϸ��� ��ǰ�ڵ�
		int reAmount=sendAmount+delInven;
		dto.setInven(reAmount); //����� �ֹ����� �Է�
		dto.setBuycode(sendBuycode);//�ش�� ��ǰ�ڵ� �Է�
		int isSucess=pDao.invenUpdate(dto);
		if(isSucess==1) {
			oDao.delete(delcNum);
		}
	}
	//�ֹ����� �޼ҵ�
	public static void update() {
		boolean find=false;
		int buyamount;
		int cnum=showorder();// ������ �ֹ��� ���� Ȯ���ϴ� �޼ҵ� ȣ��  �� ȸ����ȣ ���� �޼ҵ�
		System.out.println();
		System.out.print("�����Ϸ��� ��ǰ �ֹ���ȣ�� �Է�: "); //�⺻Ű�ش�
		int updateNum=scan.nextInt();
		productMethod.selectAll_1(); //��ǰ���� ���
		System.out.print("�����Ϸ��� ��ǰ�ڵ� �Է�: ");
		int buycode=scan.nextInt();
		while(true) {
			System.out.print("�����Ϸ��� ���� �Է�: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<��� �����ϴ�..>>");
				continue;
			}
			break;
		}
		System.out.print("������� �Է�: ");
		String buyway=scan.next();
		ArrayList<orderDto> olist=oDao.sendAmount(updateNum);
		orderDto odto=olist.get(0);
		int originAmount=odto.getBuyamount(); //���� �����ϱ� �� �ֹ��� ���� ��������
		
		ArrayList<productDto> plist=pDao.sendInven(buycode);
		productDto pdto=plist.get(0);
		int storedAmount=pdto.getInven(); //���� �����ϱ� �� �ش��ϴ� ��ǰ�� ������ ��������
		int updateInven=storedAmount + originAmount - buyamount; //���������� ��, ����Ǿ�� �� ��ǰ�� ��� ������ֱ�
		pdto.setInven(updateInven); //dto�� ������ �� �������ֱ�
		int isSuccess=pDao.invenUpdate(pdto);
		if(isSuccess==1) {
			ArrayList<productDto> list=pDao.select(buycode);
			productDto dto=list.get(0);
			int updateSum=buyamount*dto.getPrice();
			orderDto redto=new orderDto(updateNum, buyamount, updateSum, buyway, cnum, buycode, 0);
			oDao.update(redto);
		}
	}
	//������ �ֹ��� ���� Ȯ���ϴ� �κи޼ҵ�
	public static int showorder() {
		System.out.print("������ ȸ����ȣ�� �Է��ϼ���: ");
		int cnum=scan.nextInt();
		ArrayList<customerDto> clist=ccDao.select(cnum);
		customerDto cDto=clist.get(0);
		String cname=cDto.getCname();
		System.out.println("<< ["+cname+"] ���� ��ǰ�ֹ� ��������Ʈ >>");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�ֹ���ȣ\t���̸�\t�ֹ���ǰ\t�ֹ�����\t�Ѱ����ݾ�\t�ù��� �̸�       �ù��� ����ó");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
						+"��\t"+dto.getSumprice()+"��\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
						System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			}
		}else {
			System.out.println("<<�ֹ��� ������ �����ϴ�..>>");
		}
		return cnum;
	}
	
	
}
