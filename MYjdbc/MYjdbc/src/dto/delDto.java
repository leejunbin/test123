package dto;

public class delDto {
	private int delcode; //택배기사 번호(기본키)
	private String delname; //택배기사 이름
	private String delphone; //택배기사 전화번호
	private String delmail; //택배기사 이메일
	private int companycode; //택배회사 번호(외래키)
	
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
