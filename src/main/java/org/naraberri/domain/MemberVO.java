package org.naraberri.domain;

import java.util.Date;

public class MemberVO {

	private Integer mno;
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date joindate;
	private String fileupload;

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getfileupload() {
		return fileupload;
	}

	public void setfileupload(String fileupload) {
		this.fileupload = fileupload;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", email=" + email + ", joindate=" + joindate + ", fileupload=" + fileupload + "]";
	}

}