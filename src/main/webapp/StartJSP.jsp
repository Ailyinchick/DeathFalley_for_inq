<%--
  Created by IntelliJ IDEA.
  User: ailyi
  Date: 22.09.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Death Valley</title>
</head>
<body>
<form action="FindByID">
    <input type="text" name="userID"/>
    <input type="submit" name="Submit">
    <p> Find by id: ${findbyid} </p>
</form>
<form action="FindAll">
    <input type="submit" value="Display bank">
    <p>Accounts: ${account}</p>
</form>
<form action="Servlet3" method="get">
    Find the richest <input type="submit" value="Submit"/>
    <p> Name: ${name}</p>
</form>
<form action="Servlet4" method="get">
    Get total bank <input type="submit" value="Submit"/>
    <p> Name: ${summ}</p>
</form>
</body>
</html>
