<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>

<h3>Email validation</h3>

<p style="color: red">${message}</p>
<form action="/validate" method="post">
    <input type="text" name="email">
    <br>
    <input type="submit" value="validate">
</form>

</body>
</html>
