package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.model.User;
import com.besant.service.LoginService;
import com.besant.utils.JdbcConnection;

public class LoginServiceImpl implements LoginService {

	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbc(); // Ensure the connection is established
			String SelectQuery = "SELECT * FROM studentmanagement.userstable WHERE email = ? AND password = ?;";

			PreparedStatement pre = JdbcConnection.con.prepareStatement(SelectQuery);
			PrintWriter out = res.getWriter();

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			pre.setString(1, email);
			pre.setString(2, password);

			ResultSet resultSet = pre.executeQuery();

			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				// storing id temporary
				HttpSession session = req.getSession();
				session.setAttribute("uid", resultSet.getInt("id"));
				res.sendRedirect("dashboard.html");
			} else {
				out.println("logged in failed");
			}
			// Close resources
			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
