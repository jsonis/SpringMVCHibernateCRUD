<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medical Research Program</title>
</head>
<body>
	<div align="center">
		<div>
		<h1>Program List</h1>
		<table border="1">

			<th>Program Type</th>
			<th>State</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Cost</th>
			<th>Funding Status</th>
			<th>Supervisor Id</th>
			<th>Action</th>

		<c:forEach var="program" items="${listProgram}">
				<tr>

					<td>${program.program_Type}</td>
					<td>${program.state}</td>
					<td>${program.start_date}</td>
					<td>${program.end_date}</td>
					<td>${program.cost}</td>
					<td>${program.funding_status}</td>
					<td>${program.supervisor_Id}</td>
					<td><a href="editProgram?id=${program.program_Id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteProgram?id=${program.program_Id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>

	</div>
</body>
</html>