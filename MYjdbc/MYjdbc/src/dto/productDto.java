package dto;

public class productDto {
	private int buycode; //��ǰ��ȣ(�⺻Ű)
	private String pname; //��ǰ��
	private int price; //��ǰ����
	private String color; //��ǰ����
	private int inven; //������
	
	public productDto() {}
	public productDto(int buycode,String pname,int price,String color,int inven) {
		this.buycode=buycode;
		this.pname=pname;
		this.price=price;
		this.color=color;
		this.inven=inven;
	}
	public productDto(int buycode,int inven) { //��� ����� ���� ������ �߰� 
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
