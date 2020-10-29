package com.sharestore2.vo;

public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String phone;
	private String mail;
	private String gender;
	private int birth_y;
	private int birth_m;
	private int birth_d;
	private String address;
	
	public MemberVO() {}
	
	public MemberVO(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getBirth_y() {
		return birth_y;
	}
	public void setBirth_y(int birth_y) {
		this.birth_y = birth_y;
	}
	public int getBirth_m() {
		return birth_m;
	}
	public void setBirth_m(int birth_m) {
		this.birth_m = birth_m;
	}
	public int getBirth_d() {
		return birth_d;
	}
	public void setBirth_d(int birth_d) {
		this.birth_d = birth_d;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
