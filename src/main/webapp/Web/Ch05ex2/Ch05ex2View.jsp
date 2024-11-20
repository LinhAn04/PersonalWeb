<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Exercise 5.2 Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Ch05ex2/Ch05.css" type="text/css">
</head>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>

<form id="myForm" action="Ch05ex2">
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>First Name:</label>
    <input type="text" name="firstName" required><br>
    <label>Last Name:</label>
    <input type="text" name="lastName" required><br>
    <input type="hidden" name="action" value="add">

  <label for="method">Choose method:</label>
  <select id="method" name="method" onchange="setFormMethod()">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
  </select>

  <button class="button" type="submit">Submit</button>
</form>

<script>
  function setFormMethod() {
    var form = document.getElementById("myForm");
    var method = document.getElementById("method").value;
    form.method = method;  // Cập nhật phương thức của form
  }
</script>

<form action="returnHome" method="get">
    <input class="btnHome" type="submit" value="Return Home" id="home">
</form>

</body>
</html>