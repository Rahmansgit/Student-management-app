package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.utils.JdbcConnection;

public class DeleteStudentRecordServiceImpl {
	public void deleteStudentRecord(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "DELETE FROM studentManagement.students WHERE id=?;";
			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			int id = Integer.parseInt(req.getParameter("id"));
			pre.setInt(1, id);
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("/StudnetManagement/GetStudents");
			} else {
				out.println("<h2>Error: No rows deleted. The record might not exist.</h2>");
			}
			pre.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
