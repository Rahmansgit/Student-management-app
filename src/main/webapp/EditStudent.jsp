<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.besant.model.Student" %>
<html>
<head>
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            color: #333;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input[type="text"], input[type="date"], input[type="email"] {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h2>Update Student Information</h2>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    for(Student student : students) {
%>
    <form action="update" method="POST">
        <input type="hidden" name="id" value="<%= student.getId() %>">
        
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="<%= student.getStudentId() %>" readonly>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= student.getEmail() %>">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= student.getName() %>">

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" value="<%= student.getPhoneNumber() %>">

        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="<%= student.getDepartment() %>">

        <label for="course">Course:</label>
        <input type="text" id="course" name="course" value="<%= student.getCourse() %>">

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="<%= student.getAddress() %>">



        <label for="creatorId">Creator ID:</label>
        <input type="text" id="creatorId" name="creatorId" value="<%= student.getCreatorId() %>" readonly>

        <input type="submit" value="Update">
    </form>
<%
    }
%>

</body>
</html>
