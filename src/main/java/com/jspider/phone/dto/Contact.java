package com.jspider.phone.dto;

public class Contact {
private int id;
private String name;
private String email;
private String phone_no;
private String about;
private int userId;

public Contact() {
	super();
}

public Contact(int id, String name, String email, String phone_no, String about, int userId) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone_no = phone_no;
	this.about = about;
	this.userId = userId;
}


public Contact(String name, String email, String phone_no, String about, int userId) {
	super();
	this.name = name;
	this.email = email;
	this.phone_no = phone_no;
	this.about = about;
	this.userId = userId;
}

public int getId() {
	return id;
}

public void setId(int id) {
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

public String getPhone_no() {
	return phone_no;
}

public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}

public String getAbout() {
	return about;
}

public void setAbout(String about) {
	this.about = about;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phone_no=" + phone_no + ", about=" + about
			+ ", userId=" + userId + "]";
}


}
