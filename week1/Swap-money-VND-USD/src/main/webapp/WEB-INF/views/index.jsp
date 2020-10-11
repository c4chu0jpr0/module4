<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/5/2020
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<h1>Calculate: </h1>
<form action= "/calculate?vnd=" >
    <input type="number" name="vnd" value="${vnd}">
    <input type="submit" value="submit">
</form>
<p>Result: ${usd}</p>
</body>
</html>
