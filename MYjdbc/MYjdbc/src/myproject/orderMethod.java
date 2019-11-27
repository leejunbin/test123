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
	
	//輿僥蹺陛 詭模萄
	public static void insert() {
		boolean find=false;
		int buyamount;
		System.out.println("[輿僥蹺陛]");
		System.out.print("堅偌廓�� 殮溘: ");
		int cnum=scan.nextInt();
		productMethod.selectAll_1(); //僭ヶ薑爾 轎溘
		System.out.print("餌溥朝 僭勒囀萄 殮溘: ");
		int buycode=scan.nextInt();
		ArrayList<productDto> list=pDao.select(buycode);
		productDto dto=list.get(0);
		while(true) {
			System.out.print("熱榆殮溘: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<輿僥ж褐 熱榆曖 營堅陛 睡褶м棲棻..>>");
				continue;
			}
			break;
		}
		int sumprice=buyamount * dto.getPrice(); //識唸薯旎擋
		System.out.print("唸薯熱欽 殮溘: ");
		String buyway=scan.next();
		int delcode=com.sendDelcode(); //鷗寡晦餌 囀萄 楠渾高 嫡嬴螃晦
		orderDto oDto=new orderDto(0, buyamount, sumprice, buyway, cnum, buycode,delcode);
		oDao.insert(oDto);
		int updateInven=dto.getInven()-buyamount; //輿僥籀葬�� 陴擎 營堅僭榆
		productDto updateDto=new productDto(buycode, updateInven);
		pDao.invenUpdate(updateDto); //輿僥ж堅 陴擎 營堅 纔檜綰縑 機等檜お п輿晦
	}
	//輿僥瞪羹褻�� 詭模萄
	public static void selectAll() {
		System.out.println("<<瞪羹輿僥頂羲 褻��>>");
		ArrayList<orderDto> list=oDao.selectAll();
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("輿僥廓�αt輿僥熱榆\t識唸薯擋\t唸薯熱欽\t�蛾躟痤嫹t僭ヶ囀萄\t鷗寡晦餌囀萄");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for(int i=0;i<list.size();i++) {
			orderDto dto=list.get(i);
			System.out.println("  "+dto.getOrdernum()+"\t  "+dto.getBuyamount()+"偃\t"+dto.getSumprice()+"錳\t  "+dto.getBuyway()
			+"\t  "+dto.getCnum()+"\t "+dto.getBuycode()+"\t   "+dto.getDelcode());
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		}
	}
	//獄檣檜 輿僥и �蛾讔僅� --褻檣樓撩 檜辨
	public static void select() {
		System.out.println("[�蛾讔砦拿遛氓");
		System.out.print("�蛾衋� 囀萄殮溘: ");
		int cnum=scan.nextInt();
		System.out.println("<<僭ヶ輿僥 頂羲葬蝶お>>");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("輿僥廓�αt堅偌檜葷\t輿僥鼻ヶ\t輿僥熱榆\t識唸薯旎擋\t鷗寡晦餌 檜葷       鷗寡晦餌 翱塊籀");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
				+"偃\t"+dto.getSumprice()+"錳\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			}
		}else {
			System.out.println("<<輿僥и 頂羲檜 橈蝗棲棻..>>");
		}
	}
	//輿僥 鏃模 詭模萄
	public static void delete() {
		showorder();// 獄檣檜 輿僥и 頂羲 �挫恉炴� 詭模萄 ��轎
		System.out.print("鏃模ж溥朝  輿僥廓�ㄧ� 殮溘: ");
		int delcNum=scan.nextInt();
		ArrayList<orderDto> olist=oDao.sendAmount(delcNum);
		orderDto odto=olist.get(0);
		int buycode=odto.getBuycode();
		ArrayList<productDto> list=pDao.sendInven(buycode);
		productDto dto=list.get(0);
		int delInven=dto.getInven();//輿僥и 鼻ヶ曖 營堅熱榆
		ArrayList<orderDto> list1=oDao.sendAmount(delcNum);
		orderDto dto1=list1.get(0);
		int sendAmount=dto1.getBuyamount();//輿僥鏃模ж溥朝 掘衙熱榆
		int sendBuycode=dto1.getBuycode();//輿僥鏃模ж溥朝 僭ヶ囀萄
		int reAmount=sendAmount+delInven;
		dto.setInven(reAmount); //滲唳脹 輿僥熱榆 殮溘
		dto.setBuycode(sendBuycode);//п渡脹 僭ヶ囀萄 殮溘
		int isSucess=pDao.invenUpdate(dto);
		if(isSucess==1) {
			oDao.delete(delcNum);
		}
	}
	//輿僥熱薑 詭模萄
	public static void update() {
		boolean find=false;
		int buyamount;
		int cnum=showorder();// 獄檣檜 輿僥и 頂羲 �挫恉炴� 詭模萄 ��轎  塽 �蛾纗醽� 葬欐 詭模萄
		System.out.println();
		System.out.print("熱薑ж溥朝 僭ヶ 輿僥廓�ㄧ� 殮溘: "); //晦獄酈п渡
		int updateNum=scan.nextInt();
		productMethod.selectAll_1(); //僭ヶ薑爾 轎溘
		System.out.print("熱薑ж溥朝 僭ヶ囀萄 殮溘: ");
		int buycode=scan.nextInt();
		while(true) {
			System.out.print("熱薑ж溥朝 熱榆 殮溘: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<營堅陛 橈蝗棲棻..>>");
				continue;
			}
			break;
		}
		System.out.print("唸薯寞衝 殮溘: ");
		String buyway=scan.next();
		ArrayList<orderDto> olist=oDao.sendAmount(updateNum);
		orderDto odto=olist.get(0);
		int originAmount=odto.getBuyamount(); //偃熱 熱薑ж晦 瞪 輿僥脹 熱榆 陛螳螃晦
		
		ArrayList<productDto> plist=pDao.sendInven(buycode);
		productDto pdto=plist.get(0);
		int storedAmount=pdto.getInven(); //偃熱 熱薑ж晦 瞪 п渡ж朝 僭ヶ曖 營堅熱榆 陛螳螃晦
		int updateInven=storedAmount + originAmount - buyamount; //熱榆熱薑脹 ��, 滲唳腎橫撿 й 僭ヶ曖 營堅 啗骯п輿晦
		pdto.setInven(updateInven); //dto縑 熱薑脹 高 盪濰п輿晦
		int isSuccess=pDao.invenUpdate(pdto);
		if(isSuccess==1) {
			ArrayList<productDto> list=pDao.select(buycode);
			productDto dto=list.get(0);
			int updateSum=buyamount*dto.getPrice();
			orderDto redto=new orderDto(updateNum, buyamount, updateSum, buyway, cnum, buycode, 0);
			oDao.update(redto);
		}
	}
	//獄檣檜 輿僥и 頂羲 �挫恉炴� 睡碟詭模萄
	public static int showorder() {
		System.out.print("獄檣曖 �蛾纗醽ㄧ� 殮溘ж撮螃: ");
		int cnum=scan.nextInt();
		ArrayList<customerDto> clist=ccDao.select(cnum);
		customerDto cDto=clist.get(0);
		String cname=cDto.getCname();
		System.out.println("<< ["+cname+"] 椒曖 僭ヶ輿僥 頂羲葬蝶お >>");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("輿僥廓�αt堅偌檜葷\t輿僥鼻ヶ\t輿僥熱榆\t識唸薯旎擋\t鷗寡晦餌 檜葷       鷗寡晦餌 翱塊籀");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
						+"偃\t"+dto.getSumprice()+"錳\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
						System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			}
		}else {
			System.out.println("<<輿僥и 頂羲檜 橈蝗棲棻..>>");
		}
		return cnum;
	}
	
	
}
