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
	
	//ÁÖ¹®Ãß°¡ ¸Þ¼Òµå
	public static void insert() {
		boolean find=false;
		int buyamount;
		System.out.println("[ÁÖ¹®Ãß°¡]");
		System.out.print("°í°´¹øÈ£ ÀÔ·Â: ");
		int cnum=scan.nextInt();
		productMethod.selectAll_1(); //¹°Ç°Á¤º¸ Ãâ·Â
		System.out.print("»ç·Á´Â ¹°°ÇÄÚµå ÀÔ·Â: ");
		int buycode=scan.nextInt();
		ArrayList<productDto> list=pDao.select(buycode);
		productDto dto=list.get(0);
		while(true) {
			System.out.print("¼ö·®ÀÔ·Â: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<ÁÖ¹®ÇÏ½Å ¼ö·®ÀÇ Àç°í°¡ ºÎÁ·ÇÕ´Ï´Ù..>>");
				continue;
			}
			break;
		}
		int sumprice=buyamount * dto.getPrice(); //ÃÑ°áÁ¦±Ý¾×
		System.out.print("°áÁ¦¼ö´Ü ÀÔ·Â: ");
		String buyway=scan.next();
		int delcode=com.sendDelcode(); //ÅÃ¹è±â»ç ÄÚµå ·£´ý°ª ¹Þ¾Æ¿À±â
		orderDto oDto=new orderDto(0, buyamount, sumprice, buyway, cnum, buycode,delcode);
		oDao.insert(oDto);
		int updateInven=dto.getInven()-buyamount; //ÁÖ¹®Ã³¸®ÈÄ ³²Àº Àç°í¹°·®
		productDto updateDto=new productDto(buycode, updateInven);
		pDao.invenUpdate(updateDto); //ÁÖ¹®ÇÏ°í ³²Àº Àç°í Å×ÀÌºí¿¡ ¾÷µ¥ÀÌÆ® ÇØÁÖ±â
	}
	//ÁÖ¹®ÀüÃ¼Á¶È¸ ¸Þ¼Òµå
	public static void selectAll() {
		System.out.println("<<ÀüÃ¼ÁÖ¹®³»¿ª Á¶È¸>>");
		ArrayList<orderDto> list=oDao.selectAll();
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÁÖ¹®¹øÈ£\tÁÖ¹®¼ö·®\tÃÑ°áÁ¦¾×\t°áÁ¦¼ö´Ü\tÈ¸¿øÄÚµå\t¹°Ç°ÄÚµå\tÅÃ¹è±â»çÄÚµå");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for(int i=0;i<list.size();i++) {
			orderDto dto=list.get(i);
			System.out.println("  "+dto.getOrdernum()+"\t  "+dto.getBuyamount()+"°³\t"+dto.getSumprice()+"¿ø\t  "+dto.getBuyway()
			+"\t  "+dto.getCnum()+"\t "+dto.getBuycode()+"\t   "+dto.getDelcode());
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
	}
	//º»ÀÎÀÌ ÁÖ¹®ÇÑ È¸¿øÁ¶È¸ --Á¶ÀÎ¼Ó¼º ÀÌ¿ë
	public static void select() {
		System.out.println("[È¸¿øÁÖ¹®³»¿ª]");
		System.out.print("È¸¿øÀÇ ÄÚµåÀÔ·Â: ");
		int cnum=scan.nextInt();
		System.out.println("<<¹°Ç°ÁÖ¹® ³»¿ª¸®½ºÆ®>>");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÁÖ¹®¹øÈ£\t°í°´ÀÌ¸§\tÁÖ¹®»óÇ°\tÁÖ¹®¼ö·®\tÃÑ°áÁ¦±Ý¾×\tÅÃ¹è±â»ç ÀÌ¸§       ÅÃ¹è±â»ç ¿¬¶ôÃ³");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
				+"°³\t"+dto.getSumprice()+"¿ø\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
				System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			}
		}else {
			System.out.println("<<ÁÖ¹®ÇÑ ³»¿ªÀÌ ¾ø½À´Ï´Ù..>>");
		}
	}
	//ÁÖ¹® Ãë¼Ò ¸Þ¼Òµå
	public static void delete() {
		showorder();// º»ÀÎÀÌ ÁÖ¹®ÇÑ ³»¿ª È®ÀÎÇÏ´Â ¸Þ¼Òµå È£Ãâ
		System.out.print("Ãë¼ÒÇÏ·Á´Â  ÁÖ¹®¹øÈ£¸¦ ÀÔ·Â: ");
		int delcNum=scan.nextInt();
		ArrayList<orderDto> olist=oDao.sendAmount(delcNum);
		orderDto odto=olist.get(0);
		int buycode=odto.getBuycode();
		ArrayList<productDto> list=pDao.sendInven(buycode);
		productDto dto=list.get(0);
		int delInven=dto.getInven();//ÁÖ¹®ÇÑ »óÇ°ÀÇ Àç°í¼ö·®
		ArrayList<orderDto> list1=oDao.sendAmount(delcNum);
		orderDto dto1=list1.get(0);
		int sendAmount=dto1.getBuyamount();//ÁÖ¹®Ãë¼ÒÇÏ·Á´Â ±¸¸Å¼ö·®
		int sendBuycode=dto1.getBuycode();//ÁÖ¹®Ãë¼ÒÇÏ·Á´Â ¹°Ç°ÄÚµå
		int reAmount=sendAmount+delInven;
		dto.setInven(reAmount); //º¯°æµÈ ÁÖ¹®¼ö·® ÀÔ·Â
		dto.setBuycode(sendBuycode);//ÇØ´çµÈ ¹°Ç°ÄÚµå ÀÔ·Â
		int isSucess=pDao.invenUpdate(dto);
		if(isSucess==1) {
			oDao.delete(delcNum);
		}
	}
	//ÁÖ¹®¼öÁ¤ ¸Þ¼Òµå
	public static void update() {
		boolean find=false;
		int buyamount;
		int cnum=showorder();// º»ÀÎÀÌ ÁÖ¹®ÇÑ ³»¿ª È®ÀÎÇÏ´Â ¸Þ¼Òµå È£Ãâ  ¹× È¸¿ø¹øÈ£ ¸®ÅÏ ¸Þ¼Òµå
		System.out.println();
		System.out.print("¼öÁ¤ÇÏ·Á´Â ¹°Ç° ÁÖ¹®¹øÈ£¸¦ ÀÔ·Â: "); //±âº»Å°ÇØ´ç
		int updateNum=scan.nextInt();
		productMethod.selectAll_1(); //¹°Ç°Á¤º¸ Ãâ·Â
		System.out.print("¼öÁ¤ÇÏ·Á´Â ¹°Ç°ÄÚµå ÀÔ·Â: ");
		int buycode=scan.nextInt();
		while(true) {
			System.out.print("¼öÁ¤ÇÏ·Á´Â ¼ö·® ÀÔ·Â: ");
			buyamount=scan.nextInt();
			find=oDao.isInven(buycode, buyamount);
			if(find) {
				System.out.println("<<Àç°í°¡ ¾ø½À´Ï´Ù..>>");
				continue;
			}
			break;
		}
		System.out.print("°áÁ¦¹æ½Ä ÀÔ·Â: ");
		String buyway=scan.next();
		ArrayList<orderDto> olist=oDao.sendAmount(updateNum);
		orderDto odto=olist.get(0);
		int originAmount=odto.getBuyamount(); //°³¼ö ¼öÁ¤ÇÏ±â Àü ÁÖ¹®µÈ ¼ö·® °¡Á®¿À±â
		
		ArrayList<productDto> plist=pDao.sendInven(buycode);
		productDto pdto=plist.get(0);
		int storedAmount=pdto.getInven(); //°³¼ö ¼öÁ¤ÇÏ±â Àü ÇØ´çÇÏ´Â ¹°Ç°ÀÇ Àç°í¼ö·® °¡Á®¿À±â
		int updateInven=storedAmount + originAmount - buyamount; //¼ö·®¼öÁ¤µÈ ÈÄ, º¯°æµÇ¾î¾ß ÇÒ ¹°Ç°ÀÇ Àç°í °è»êÇØÁÖ±â
		pdto.setInven(updateInven); //dto¿¡ ¼öÁ¤µÈ °ª ÀúÀåÇØÁÖ±â
		int isSuccess=pDao.invenUpdate(pdto);
		if(isSuccess==1) {
			ArrayList<productDto> list=pDao.select(buycode);
			productDto dto=list.get(0);
			int updateSum=buyamount*dto.getPrice();
			orderDto redto=new orderDto(updateNum, buyamount, updateSum, buyway, cnum, buycode, 0);
			oDao.update(redto);
		}
	}
	//º»ÀÎÀÌ ÁÖ¹®ÇÑ ³»¿ª È®ÀÎÇÏ´Â ºÎºÐ¸Þ¼Òµå
	public static int showorder() {
		System.out.print("º»ÀÎÀÇ È¸¿ø¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿À: ");
		int cnum=scan.nextInt();
		ArrayList<customerDto> clist=ccDao.select(cnum);
		customerDto cDto=clist.get(0);
		String cname=cDto.getCname();
		System.out.println("<< ["+cname+"] ´ÔÀÇ ¹°Ç°ÁÖ¹® ³»¿ª¸®½ºÆ® >>");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÁÖ¹®¹øÈ£\t°í°´ÀÌ¸§\tÁÖ¹®»óÇ°\tÁÖ¹®¼ö·®\tÃÑ°áÁ¦±Ý¾×\tÅÃ¹è±â»ç ÀÌ¸§       ÅÃ¹è±â»ç ¿¬¶ôÃ³");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		ArrayList<orderDto> list=oDao.select(cnum);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				orderDto dto=list.get(i);
				System.out.println("  "+dto.getOrdernum()+"\t "+dto.getCname()+"\t"+dto.getPname()+"\t "+dto.getBuyamount()
						+"°³\t"+dto.getSumprice()+"¿ø\t   "+dto.getDelname()+"\t   "+dto.getDelphone());
						System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			}
		}else {
			System.out.println("<<ÁÖ¹®ÇÑ ³»¿ªÀÌ ¾ø½À´Ï´Ù..>>");
		}
		return cnum;
	}
	
	
}
