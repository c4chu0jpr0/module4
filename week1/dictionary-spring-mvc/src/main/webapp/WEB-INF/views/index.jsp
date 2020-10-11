<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/5/2020
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="/dictionary?word=">
    <input type="text" name="word">
    <input type="submit" value="search">
</form>
<p>Result: ${result}</p>
</body>
</html>
