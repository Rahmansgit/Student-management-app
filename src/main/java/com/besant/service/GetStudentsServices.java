package com.besant.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;

public interface GetStudentsServices {
	
	public List<Student> viewStudents(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}
