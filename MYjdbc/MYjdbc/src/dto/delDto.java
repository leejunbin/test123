package dto;

public class delDto {
	private int delcode; //�ù��� ��ȣ(�⺻Ű)
	private String delname; //�ù��� �̸�
	private String delphone; //�ù��� ��ȭ��ȣ
	private String delmail; //�ù��� �̸���
	private int companycode; //�ù�ȸ�� ��ȣ(�ܷ�Ű)
	
	public delDto() {}
	public delDto(int delcode,String delname,String delphone,String delmail,int companycode) {
		this.delcode=delcode;
		this.delname=delname;
		this.delphone=delphone;
		this.delmail=delmail;
		this.companycode=companycode;
	}
	public int getDelcode() {
		return delcode;
	}
	public void setDelcode(int delcode) {
		this.delcode = delcode;
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
	public String getDelmail() {
		return delmail;
	}
	public void setDelmail(String delmail) {
		this.delmail = delmail;
	}
	public int getCompanycode() {
		return companycode;
	}
	public void setCompanycode(int companycode) {
		this.companycode = companycode;
	}
	
}
