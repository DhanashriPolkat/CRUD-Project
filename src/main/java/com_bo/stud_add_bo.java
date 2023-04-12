package com_bo;

public class stud_add_bo 
{
	private String id;
	private String name;
	private String email;
	private String phone;
	private String doj;
	private String eoj;
	private String adhar;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getEoj() {
		return eoj;
	}
	public void setEoj(String eoj) {
		this.eoj = eoj;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public stud_add_bo(String id, String name, String email, String phone, String doj, String eoj, String adhar) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
		this.eoj = eoj;
		this.adhar = adhar;
	}
	public stud_add_bo() {
		super();
	}
	@Override
	public String toString() {
		return "stud_add_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", doj=" + doj
				+ ", eoj=" + eoj + ", adhar=" + adhar + "]";
	}
	
	
	
	

}
