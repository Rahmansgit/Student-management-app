package com.besant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.besant.model.Student;
import com.besant.services.impl.GetStudentsServicesImpl;
@WebServlet("/GetStudents")
public class GetStudents extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Set CORS headers to allow requests from Angular app
        res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        // Call your service to get the student data
        GetStudentsServicesImpl service = new GetStudentsServicesImpl();
        List<Student> students = service.getStudentList();  // new method that returns List<Student>

        // Convert the list of students to JSON array
        JSONArray jsonArray = new JSONArray();
        for (Student student : students) {
            JSONObject studentJson = new JSONObject();
            studentJson.put("id", student.getId());
            studentJson.put("name", student.getName());
            studentJson.put("studentId", student.getStudentId());
            studentJson.put("email", student.getEmail());
            studentJson.put("phoneNumber", student.getPhoneNumber());
            studentJson.put("department", student.getDepartment());
            studentJson.put("course", student.getCourse());
            studentJson.put("address", student.getAddress());
            studentJson.put("creatorId", student.getCreatorId());
            studentJson.put("createdAt", student.getCreatedAt().toString());
            jsonArray.put(studentJson);
        }

        // Write JSON data to the response
        PrintWriter out = res.getWriter();
        out.print(jsonArray);
        out.flush();
    }

    // Add a handler for OPTIONS request to support preflight requests
    protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        res.setStatus(HttpServletResponse.SC_OK);
    }
}