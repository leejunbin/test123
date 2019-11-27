package dto;

public class productDto {
	private int buycode; //제품번호(기본키)
	private String pname; //제품명
	private int price; //제품가격
	private String color; //제품색상
	private int inven; //재고수량
	
	public productDto() {}
	public productDto(int buycode,String pname,int price,String color,int inven) {
		this.buycode=buycode;
		this.pname=pname;
		this.price=price;
		this.color=color;
		this.inven=inven;
	}
	public productDto(int buycode,int inven) { //재고 계산을 위한 생성자 추가 
		this.buycode=buycode;
		this.inven=inven;
	}
	public int getInven() {
		return inven;
	}
	public void setInven(int inven) {
		this.inven = inven;
	}
	public int getBuycode() {
		return buycode;
	}
	public void setBuycode(int buycode) {
		this.buycode = buycode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
