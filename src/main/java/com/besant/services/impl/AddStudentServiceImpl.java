package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.model.User;
import com.besant.service.AddStudentService;
import com.besant.utils.JdbcConnection;

public class AddStudentServiceImpl implements AddStudentService {

	@Override
	public void addStudent(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "INSERT INTO studentmanagement.students ( name, studentId, email, phoneNumber, department, course, address, passout, dob, creatorId) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			Student student = new Student();
			student.setName(req.getParameter("name"));
			student.setStudentId(req.getParameter("studId"));
			student.setEmail(req.getParameter("email"));
			student.setPhoneNumber(req.getParameter("phnNo"));
			student.setDepartment(req.getParameter("department"));
			student.setCourse(req.getParameter("course"));
			student.setAddress(req.getParameter("address"));
			student.setPassout(req.getParameter("passYear"));
			student.setDob(req.getParameter("dob"));

			pre.setString(1, student.getName());
			pre.setString(2, student.getStudentId());
			pre.setString(3, student.getEmail());
			pre.setString(4, student.getPhoneNumber());
			pre.setString(5, student.getDepartment());
			pre.setString(6, student.getCourse());
			pre.setString(7, student.getAddress());
			pre.setString(8, student.getPassout());
			pre.setString(9, student.getDob());
			pre.setInt(10, 1);
			
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				 res.sendRedirect("GetStudents");
				} else {
					out.println("<h2>Error: No rows inserted.</h2>");
			}
			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}