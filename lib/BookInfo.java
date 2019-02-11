package test;

public class BookInfo {
	private String bo_id, sp_id, em_id, bo_name, date, remarks;
	private int price, store, rollalty;

	public BookInfo() {
	}

	public BookInfo(String bo_id) {
		this.bo_id = bo_id;
	}

	public BookInfo(String bo_id, String bo_name) {
		this.bo_id = bo_id;
		this.bo_name = bo_name;
	}

	public BookInfo(String bo_id, String sp_id, String em_id, String bo_name, int price, int store, String date,
			int rollalty, String remarks) {
		this.bo_id = bo_id;
		this.sp_id = sp_id;
		this.em_id = em_id;
		this.bo_name = bo_name;
		this.price = price;
		this.store = store;
		this.date = date;
		this.rollalty = rollalty;
		this.remarks = remarks;
	}

	public String getBo_id() {
		return bo_id;
	}

	public void setBo_id(String bo_id) {
		this.bo_id = bo_id;
	}

	public String getSp_id() {
		return sp_id;
	}

	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}

	public String getEm_id() {
		return em_id;
	}

	public void setEm_id(String em_id) {
		this.em_id = em_id;
	}

	public String getBo_name() {
		return bo_name;
	}

	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getRollalty() {
		return rollalty;
	}

	public void setRollalty(int rollalty) {
		this.rollalty = rollalty;
	}

}
