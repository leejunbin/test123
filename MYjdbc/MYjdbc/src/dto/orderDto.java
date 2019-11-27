package dto;

public class orderDto {
	private int ordernum; //주문번호(기본키)
	private int buyamount; //주문수량
	private int sumprice; //총 결제가격
	private String buyway; //결제수단
	private int cnum; // 고객번호(외래키)
	private int buycode; //제품번호(외래키)
	private int delcode;//택배기사 코드(외래키)
	
	private String cname; //회원이름
	private String pname; //물품명
	private String delname; //택배기사 이름
	private String delphone; //택배기사 번호
	
	public orderDto() {}
	public orderDto(int ordernum,int buyamount,int sumprice,String buyway,int cnum,int buycode,int delcode) {
		this.ordernum=ordernum;
		this.buyamount=buyamount;
		this.sumprice=sumprice;
		this.buyway=buyway;
		this.cnum=cnum;
		this.buycode=buycode;
		this.delcode=delcode;
	}
	public orderDto(int ordernum,String cname,String pname,int buyamount,int sumprice,String delname,String delphone) { //조인을 위한..
		this.ordernum=ordernum;
		this.cname=cname;
		this.pname=pname;
		this.buyamount=buyamount;
		this.sumprice=sumprice;
		this.delname=delname;
		this.delphone=delphone;
	}
	public orderDto(int buyamount,int buycode) {
		this.buyamount=buyamount;
		this.buycode=buycode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDelname() {
		return delname;
	}
	public void setDelname(String delname) {
		this.delname = delname;
	}
	public String getDelphone() {
		return delphone;
	}
	public void setDelphone(String delphone) {
		this.delphone = delphone;
	}
	public int getDelcode() {
		return delcode;
	}
	public void setDelcode(int delcode) {
		this.delcode = delcode;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getBuyamount() {
		return buyamount;
	}
	public void setBuyamount(int buyamount) {
		this.buyamount = buyamount;
	}
	public int getSumprice() {
		return sumprice;
	}
	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}
	public String getBuyway() {
		return buyway;
	}
	public void setBuyway(String buyway) {
		this.buyway = buyway;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getBuycode() {
		return buycode;
	}
	public void setBuycode(int buycode) {
		this.buycode = buycode;
	}
}
