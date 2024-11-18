package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.LoginServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		loginServiceImpl.login(req, res);
	}
}
