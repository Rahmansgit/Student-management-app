package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.SignupService;
import com.besant.utils.JdbcConnection;

public class SignupServiceImpl implements SignupService {

	@Override
	public void signup(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "INSERT INTO studentmanagement.userstable(email,password) VALUES (?,?)";

			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			pre.setString(1, email);
			pre.setString(2, password);

			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("login.html");
			} else {
				out.println("<h2>Error: No rows inserted.</h2>");
			}
			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
