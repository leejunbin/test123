package myproject;

import java.util.Scanner;

import dao.productDao;

public class myproject {
	static Scanner scan=new Scanner(System.in);
	static productDao pDao=new productDao(); //��ǰ������ ���� DAO
	public static void main(String[] args) {
		String id="";
		String pwd="";
		System.out.println("         ����������������������������������������������������������������������������������");
		System.out.println("         ��\t�߾�HTA ���θ��� ���Ű� ȯ���մϴ�!! \t ��");
		System.out.println("         ����������������������������������������������������������������������������������");
		System.out.print("\t #####   #######    #      #####    ####### \n");
		System.out.print("\t#           #      # #     #    #      #    \n");
		System.out.print("\t#####       #     #####    ######      #    \n");
		System.out.print("\t     #      #    #     #   #     #     #    \n");
		System.out.print("\t#####       #   #       #  #     #     #    \n\n");
		System.out.println("	1.ȸ�����     2.���θ������ڸ��\t3.�ù��ü�����ڸ��");
		int modeNum=scan.nextInt();
		//�����ڸ�� ��Ͻ�
		if(modeNum==2) {
			System.out.print("������������ ���̵��Է¦�����\n");
			System.out.print("����");
			id=scan.next();
			System.out.print("��������й�ȣ�Է¦�����\n");
			System.out.print("����");
			pwd=scan.next();
			if(id.equals("admin") && pwd.equals("1234")) {
				System.out.println("<<������ ���Ӽ���!!>>\n");
			}else {
				System.out.println("���̵� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
				System.exit(0); //����
			}
			while(true) {
				boolean find=false;
				System.out.println("=======================�޴��� ����=======================");
				System.out.println("1.������		2.�ֹ�����		3.��ǰ����		4.����");
				int num=scan.nextInt();
				switch(num) {
				case 1:
					System.out.println("===============�޴��� ����================");
					System.out.println("a.����ȸ�� ��ü���       b.�ֹ���ü ���       c.�ڷΰ���");
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
					System.out.println("=================�޴��� ����=================");
					System.out.println("a.�ֹ���ü��ȸ  b.�ڷΰ���");
					char editNum1=scan.next().charAt(0); //�����ϳ� �ޱ�
					switch(editNum1) {
					case 'A':
					case 'a': orderMethod.selectAll(); break;
					case 'B':
					case 'b': continue;
					}
				break;
				case 3:
					System.out.println("======================�޴��� ����=====================");
					System.out.println("a.��ǰ�߰�  b.��ǰ���� c.��ǰ���� d.��ü��ǰ��ȸ e.��ǰ�˻� f.�ڷΰ���");
					char editNum=scan.next().charAt(0); //�����ϳ� �ޱ�
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
					System.out.println("�����մϴ�...");
					find=true;
					break;
				}
				if(find) break; //����
			}
		}else if(modeNum==3) {
			System.out.print("������������ ���̵��Է¦�����\n");
			System.out.print("����");
			id=scan.next();
			System.out.print("��������й�ȣ�Է¦�����\n");
			System.out.print("����");
			pwd=scan.next();
			if(id.equals("admin") && pwd.equals("1234")) {
				System.out.println("<<�ù�ȸ������� ���Ӽ���!!>>\n");
			}else {
				System.out.println("���̵� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
				System.exit(0); //����
			}
			while(true) {
				boolean find=false;
				System.out.println("=================�޴��� ����=================");
				System.out.println("1.�ù��ü�����\t2.�ù������\t3.����");
				int delNum=scan.nextInt();
				switch(delNum) {
				case 1:
					System.out.println("=======================�޴��� ����=======================");
					System.out.println("a.��ü��� b.��ü���� c.��ü���� d.��Ͼ�ü��ü��ȸ e.��üã�� f.�ڷΰ���");
					char editNum=scan.next().charAt(0); //�����ϳ� �ޱ�
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
					System.out.println("=============================�޴��� ����=============================");
					System.out.println("a.�ù����� b.�ù������ c.�ù����������� d.��ϵȱ�� ��ü��ȸ e.���ã�� f.�ڷΰ���");
					char editNum1=scan.next().charAt(0); //�����ϳ� �ޱ�
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
					System.out.println("�����մϴ�..");
					find=true;
					break;
				}
				if(find) break;
			}
		}else if(modeNum==1) { //ȸ����� ����
			while(true) {
				boolean find=false;
				System.out.println("=================�޴��� ����=================");
				System.out.println("1.ȸ�����Ը޴�\t 2.��ǰ�ֹ�\t 3.����");
				int num=scan.nextInt();
				switch(num){
				case 1:
					System.out.println("=================�޴��� ����=================");
					System.out.println("a.ȸ������ b.ȸ��Ż�� c.ȸ���������� f.�ڷΰ���");
					char editNum=scan.next().charAt(0); //�����ϳ� �ޱ�
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
					System.out.println("=================�޴��� ����=================");
					System.out.println("a.��ǰ�ֹ� b.�ֹ���� c.�ֹ����� d.�ֹ���ȸ f.�ڷΰ���");
					char editNum1=scan.next().charAt(0); //�����ϳ� �ޱ�
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
					System.out.println("�����մϴ�..");
					find=true;
					break;
				}
				if(find) break;
			}
		}
	}
}





