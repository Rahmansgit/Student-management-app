package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.EditStudentService;
import com.besant.services.impl.EditStudentServiceImpl;

@WebServlet("/edit")
public class EditStudentController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EditStudentService service = new EditStudentServiceImpl();
		service.editStudent(req, res);
	}

}
