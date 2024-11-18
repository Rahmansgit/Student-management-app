package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.AddStudentService;
import com.besant.services.impl.AddStudentServiceImpl;

@WebServlet("/add")
public class AddStudentController extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        AddStudentService service = new AddStudentServiceImpl();
        service.addStudent(req, res);
    }
}
