package com.besant.services.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.service.EditStudentService;
import com.besant.utils.JdbcConnection;

public class EditStudentServiceImpl implements EditStudentService {

	@Override
	public void editStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();

		try {
			JdbcConnection.jdbc();

			PreparedStatement pre = JdbcConnection.con
					.prepareStatement("SELECT * FROM studentManagement.students where id= ?");

			int id = Integer.parseInt(req.getParameter("id"));

			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();

			if (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setStudentId(rs.getString("studentId"));
				student.setEmail(rs.getString("email"));
				student.setPhoneNumber(rs.getString("phoneNumber"));
				student.setDepartment(rs.getString("department"));
				student.setCourse(rs.getString("course"));
				student.setAddress(rs.getString("address"));
				student.setCreatorId(rs.getInt("creatorId"));
				student.setCreatedAt(rs.getTimestamp("createdAt"));
				students.add(student);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		req.setAttribute("students", students);
		req.getRequestDispatcher("EditStudent.jsp").forward(req, res);
	}

	@Override
	public void updateRecord(HttpServletRequest req, HttpServletResponse res) {
		try {
			// Ensure the connection is established
			JdbcConnection.jdbc();

			// SQL query to update the student record
			String updateQuery = "UPDATE studentManagement.students SET name=?, studentId=?, email=?, phoneNumber=?, department=?, course=?, address=?, passout=?, dob=?, creatorId=?, createdAt=NOW() WHERE id=?;";

			// Prepare the statement
			PreparedStatement pre = JdbcConnection.con.prepareStatement(updateQuery);
			PrintWriter out = res.getWriter();

			// Get parameters from the request
			String name = req.getParameter("name");
			String studentId = req.getParameter("studentId");
			String email = req.getParameter("email");
			String phoneNumber = req.getParameter("phoneNumber");
			String department = req.getParameter("department");
			String course = req.getParameter("course");
			String address = req.getParameter("address");
			String passout = req.getParameter("passout");
			String dob = req.getParameter("dob");
			int creatorId = Integer.parseInt(req.getParameter("creatorId"));
			int id = Integer.parseInt(req.getParameter("id")); // The student's id to update

			// Set the parameters for the prepared statement
			pre.setString(1, name);
			pre.setString(2, studentId);
			pre.setString(3, email);
			pre.setString(4, phoneNumber);
			pre.setString(5, department);
			pre.setString(6, course);
			pre.setString(7, address);
			pre.setString(8, passout);
			pre.setString(9, dob);
			pre.setInt(10, creatorId);
			pre.setInt(11, id);

			// Execute the update
			int rowsAffected = pre.executeUpdate();

			if (rowsAffected > 0) {
				// Redirect to the GetStudents page after successful update
				res.sendRedirect("/StudnetManagement/GetStudents");
			} else {
				out.println("<h2>Error: No rows updated. The record might not exist.</h2>");
			}

			pre.close();

		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace for debugging
		}
	}

}
