<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.besant.model.Student"%>
<html>
<head>
<title>Student List</title>
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

/* Navbar styles */
.navbar {
	background-color: #4CAF50;
	padding: 10px;
	text-align: center;
}

.navbar a {
	color: white;
	padding: 14px 20px;
	text-decoration: none;
	text-align: center;
}

.navbar a:hover {
	background-color: #45a049;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	background-color: #fff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}

.action-buttons {
	display: flex;
	gap: 5px;
}

.logout-btn {
	background-color: #f44336;
	color: #fff;
	border: none;
	padding: 10px 15px;
	border-radius: 5px;
	cursor: pointer;
	margin-left: 10px;
	display: inline-block;
}

.dashboard-btn {
	background-color: blue;
	color: #fff;
	border: none;
	padding: 10px 15px;
	border-radius: 5px;
	cursor: pointer;
	margin-left: 10px;
	display: inline-block;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 6px 10px;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

#delete_btn {
	background-color: red
}

/* Footer styles */
footer {
	text-align: center;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	position: relative;
	bottom: 0;
	width: 100%;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="navbar">
		<a class="dashboard-btn" href="dashboard.html">Dashboard</a> <a
			class="logout-btn" href="login.html">Logout</a>
	</div>

	<h2>Student List</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Student ID</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Department</th>
			<th>Course</th>
			<th>Address</th>
			<th>Creator ID</th>
			<th>Created At</th>
			<th>Actions</th>
		</tr>
		<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPhoneNumber()%></td>
			<td><%=student.getDepartment()%></td>
			<td><%=student.getCourse()%></td>
			<td><%=student.getAddress()%></td>
			<td><%=student.getCreatorId()%></td>
			<td><%=student.getCreatedAt()%></td>
			<td class="action-buttons">
				<form action="delete" method="POST" style="display: inline;">
					<input type="hidden" name="id" value="<%=student.getId()%>">
					<input id="delete_btn" type="submit"
						value="Delete">
				</form>
				<form action="edit" method="GET" style="display: inline;">
					<input type="hidden" name="id" value="<%=student.getId()%>">
					<input type="submit" value="Edit">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<footer> &copy; 2024 Student Management System. All Rights
		Reserved. </footer>
</body>
</html>
