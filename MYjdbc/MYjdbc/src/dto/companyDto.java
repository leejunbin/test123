package dto;

public class companyDto {
	private int companycode; //�ù�ȸ�� �ڵ�(�⺻Ű)
	private String comname; //�ù�ȸ���
	private String comloc; //ȸ����ġ(�ּ�)
	private String comphone; //ȸ����ȭ��ȣ
	public companyDto() {}
	public companyDto(int companycode,String comname,String comloc,String comphone) {
		this.companycode=companycode;
		this.comname=comname;
		this.comloc=comloc;
		this.comphone=comphone;
	}
	public int getCompanycode() {
		return companycode;
	}
	public void setCompanycode(int companycode) {
		this.companycode = companycode;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public String getComloc() {
		return comloc;
	}
	public void setComloc(String comloc) {
		this.comloc = comloc;
	}
	public String getComphone() {
		return comphone;
	}
	public void setComphone(String comphone) {
		this.comphone = comphone;
	}
}
