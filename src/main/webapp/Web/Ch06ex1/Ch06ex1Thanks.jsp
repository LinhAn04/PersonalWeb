<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>Exercise 6.1 Page</title>
<html lang="en">
<%@include file="include/header.jsp"%>
<body>

<h1>Thanks for joining our email list</h1>
<p>Here is the information that you entered:</p>

<label>Email:</label>
<span>${user.email}</span><br>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>
<p>To enter another email address, click on the Back
    button in your browser or the Return button shown
    below.</p>
<script>
    console.log("Hello, this is a message in the console!");
</script>

<form id="myForm" action="">
    <label for="method">Choose method:</label>
    <select id="method" name="method" onchange="setFormMethod()">
        <option value="GET">GET</option>
        <option value="POST">POST</option>
    </select>

    <input type="hidden" name="action" value="join">
    <input class="button" type="submit" value="Return">
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