package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.SignupServiceImpl;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		SignupServiceImpl signupServiceImpl = new SignupServiceImpl();
		signupServiceImpl.signup(req, res);
		
	}
}

