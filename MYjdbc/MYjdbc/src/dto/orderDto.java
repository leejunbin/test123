package dto;

public class orderDto {
	private int ordernum; //�ֹ���ȣ(�⺻Ű)
	private int buyamount; //�ֹ�����
	private int sumprice; //�� ��������
	private String buyway; //��������
	private int cnum; // ����ȣ(�ܷ�Ű)
	private int buycode; //��ǰ��ȣ(�ܷ�Ű)
	private int delcode;//�ù��� �ڵ�(�ܷ�Ű)
	
	private String cname; //ȸ���̸�
	private String pname; //��ǰ��
	private String delname; //�ù��� �̸�
	private String delphone; //�ù��� ��ȣ
	
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
	public orderDto(int ordernum,String cname,String pname,int buyamount,int sumprice,String delname,String delphone) { //������ ����..
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
