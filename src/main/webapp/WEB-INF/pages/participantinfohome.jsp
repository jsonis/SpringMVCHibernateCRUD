<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Participant Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Participant List</h1>
		
		<table border="1">

			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Email</th>
			<th>Action</th>

			<c:forEach var="participant" items="${listParticipant}">
				<tr>

					<td>${participant.fname}</td>
					<td>${participant.lname}</td>
					<td>${participant.age}</td>
					<td>${participant.address}</td>
					<td>${participant.contact_no}</td>
					<td>${participant.email}</td>
					<td><a href="editParticipantInfo?id=${participant.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteParticipantInfo?id=${participant.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Participant Register <a href="newParticipantInfo">here</a>
		</h4>
	</div>
</body>
</html>