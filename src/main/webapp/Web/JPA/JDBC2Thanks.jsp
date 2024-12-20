<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanks Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/JPA/JDBC.css" type="text/css">
</head>

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

<form action="" method="post">
    <input type="hidden" name="action" value="join">
    <input type="hidden" name="myExercise" value="Ch05ex1View">
    <input class="button" type="submit" value="Return">
    <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()"><br>
</form>
<script>
    function returnHome() {
        // Chuyển hướng về trang chủ mà không kiểm tra form
        window.location.href = 'returnHome';
    }
</script>
</body>
</html>
