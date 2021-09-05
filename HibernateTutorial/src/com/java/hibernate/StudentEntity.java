package com.java.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Column(name = "id")
	@Id
	int id;

	@Column(name = "fname")
	String fname;

	@Column(name = "lname")
	String lname;

	@Column(name="email")
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}

	
}
