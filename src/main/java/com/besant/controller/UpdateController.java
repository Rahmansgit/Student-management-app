package com.besant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.EditStudentService;
import com.besant.services.impl.EditStudentServiceImpl;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		EditStudentService service = new EditStudentServiceImpl();
		service.updateRecord(req, res);
	}
}
