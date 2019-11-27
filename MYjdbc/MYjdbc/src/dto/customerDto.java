package dto;

public class customerDto {
	private int cnum; //고객번호(기본키)
	private String cname; //고객이름
	private String cmail; //고객이메일
	private String cphone; //고객전화전화
	
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
