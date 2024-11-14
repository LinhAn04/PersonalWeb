<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="include/header.jsp"%>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and
    email address below.</p>
<form action="javaMail" method="get">
    <input type="hidden" name="action" value="add">

    <label>Email:</label>
    <input type="email" name="email" required><br>

    <label>First Name:</label>
    <input type="text" name="firstName" required><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" required><br>

    <label>&nbsp;</label>
    <input type="submit" value="Join Now" id="submit">
</form>
</body>
<%@include file="include/footer.jsp"%>
</html>