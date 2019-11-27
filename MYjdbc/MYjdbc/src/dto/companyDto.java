package dto;

public class companyDto {
	private int companycode; //택배회사 코드(기본키)
	private String comname; //택배회사명
	private String comloc; //회사위치(주소)
	private String comphone; //회사전화번호
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
