package test;

public class authorsTable {
	private String au_id, au_name, phone, address, contact;

	public authorsTable() {
	}

	public authorsTable(String au_id,String au_name) {
		this.au_id = au_id;
		this.au_name=au_name;
	}

	public authorsTable(String au_id, String au_name, String phone, String address, String contact) {
		this.au_id = au_id;
		this.au_name = au_name;
		this.phone = phone;
		this.address = address;
		this.contact = contact;
	}

	public String getAu_id() {
		return au_id;
	}

	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}

	public String getAu_name() {
		return au_name;
	}

	public void setAu_name(String au_name) {
		this.au_name = au_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
