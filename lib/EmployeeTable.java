package test;


public class EmployeeTable {
	private String em_id,em_name,sex,hire_date,month_pay,phone;
	int job;
	public EmployeeTable() {}
	public EmployeeTable(String em_id,String em_name) {
		this.em_id=em_id;
		this.em_name=em_name;
	}
	public EmployeeTable(String em_id,String em_name,String sex,int job,String hire_date,String month_pay,String phone){
		this.em_id=em_id;
		this.em_name=em_name;
		this.sex=sex;
		this.job=job;
		this.hire_date=hire_date;
		this.month_pay=month_pay;
		this.phone=phone;
	}
	public String getEm_id() {
		return em_id;
	}
	public void setEm_id(String em_id) {
		this.em_id = em_id;
	}
	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getMonth_pay() {
		return month_pay;
	}
	public void setMonth_pay(String month_pay) {
		this.month_pay = month_pay;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
	}
	
}
