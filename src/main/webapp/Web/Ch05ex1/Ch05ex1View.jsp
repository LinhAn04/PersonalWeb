<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Exercise 5.1 Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Ch05ex1/Ch05.css" type="text/css">
</head>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>
<%--<p class="mess"><i>${message}</i></p>--%>

<form action="${pageContext.request.contextPath}/Ch05ex1" method="get">
  <input type="hidden" name="action" value="add">
  <label>Email:</label>
  <%--  Có "require thì tự động bắt buộc phải điền field đó--%>
  <input type="email" name="email" required><br>
  <label>First Name:</label>
  <input type="text" name="firstName" required><br>
  <label>Last Name:</label>
  <input type="text" name="lastName" required><br>
  <label>&nbsp;</label>
  <input class="button" type="submit" value="Join Now" id="submit">
</form>
</body>
</html>