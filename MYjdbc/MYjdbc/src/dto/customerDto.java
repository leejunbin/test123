package dto;

public class customerDto {
	private int cnum; //����ȣ(�⺻Ű)
	private String cname; //���̸�
	private String cmail; //���̸���
	private String cphone; //����ȭ��ȭ
	
	public customerDto() {}
	public customerDto(int cnum,String cname,String cmail,String cphone) {
		this.cnum=cnum;
		this.cname=cname;
		this.cmail=cmail;
		this.cphone=cphone;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
}
