package test;

public class SpecialTable {
	private String sp_id,sp_name;
	public SpecialTable() {
	}
	public SpecialTable(String sp_id) {
		this.sp_id=sp_id;
	}
	public SpecialTable(String sp_id,String sp_name) {
		this.sp_id=sp_id;
		this.sp_name=sp_name;
	}
	public String getSp_id() {
		return sp_id;
	}
	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
}
