<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2020
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<p>${message}</p>
<form action="/caculator" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <br>
    <input type="submit" name="operator" value="+">
    <input type="submit" name="operator" value="-">
    <input type="submit" name="operator" value="*">
    <input type="submit" name="operator" value="/">
</form>
<p>result: ${result}</p>

</body>
</html>
