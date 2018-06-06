<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Medical Research Info</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Medical Research Info</h1>
        <form:form action="saveProgram" method="post" modelAttribute="program">
        <table>
            <form:hidden path="program_Id"/>
            <tr>
                <td>Program Type:</td>
                <td><form:input path="program_Type" /></td>
            </tr>
            <tr>
                <td>Supervisor ID:</td>
                <td><form:input path="supervisor_Id" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /></td>
            </tr>
            <tr>
                <td>Start Date:</td>
                <td>  
                <form:input path="start_date" id="sdate" value="06/01/2018" /></td>
            </tr>
            <tr>
                <td>End Date:</td>
                <td><form:input path="end_date" id="edate" value="12/31/2018" /></td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td><form:input path="cost" /></td>
            </tr>
            <tr>
                <td>Funding Status:</td>
                <td><form:input path="funding_status" /></td>
            </tr>
             
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>