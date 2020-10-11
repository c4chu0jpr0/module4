<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2020
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="tomato">
    <label for="tomato"> Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="mustard">
    <label for="mustard"> Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
    <label for="sprouts"> Sprouts</label><br><br>
    <input type="submit" value="save">
</form>
<p>Lựa chọn người dùng: ${result}</p>
</body>
</html>
