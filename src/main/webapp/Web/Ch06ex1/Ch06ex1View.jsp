<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>Exercise 6.1 Page</title>
<html lang="en">
<%@include file="include/header.jsp"%>
<body>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>

<form id="myForm" action="${pageContext.request.contextPath}/Ch06ex1">
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
</body>
<%@include file="include/footer.jsp"%>
</html>
