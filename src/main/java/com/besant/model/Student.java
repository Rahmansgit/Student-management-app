package com.besant.model;

import java.util.Date;

public class Student {

	   private int id;
	    private String name;
	    private String studentId;
	    private String email;
	    private String phoneNumber;
	    private String department;
	    private String course;
	    private String address;
	    private String passout;
	    private String dob;
	    private int creatorId;
	    private Date createdAt;
	    
	    
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
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPassout() {
			return passout;
		}
		public void setPassout(String passout) {
			this.passout = passout;
		}
	
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public int getCreatorId() {
			return creatorId;
		}
		public void setCreatorId(int creatorId) {
			this.creatorId = creatorId;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
	    
	    
	    
}
