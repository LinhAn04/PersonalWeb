<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<label>Heard From:</label>
<span>${user.heardfrom}</span><br>
<label>Updates:</label>
<span>${user.update}</span><br>
<label>Contact Via:</label>
<span>${user.contactvia}</span><br>

<p>To enter another email address, click on the Back
    button in your browser or the Return button shown
    below.</p>
<script>
    console.log("Hello, this is a message in the console!");
</script>

<form id="myForm" action="">
    <label class="lmethod" for="method">Choose method:</label>
    <select class="option" id="method" name="method" onchange="setFormMethod()">
        <option value="GET">GET</option>
        <option value="POST">POST</option>
    </select>

    <input type="hidden" name="action" value="join">
    <input type="hidden" name="myExercise" value="Ch05ex2View">
    <input class="button" type="submit" value="Return">

    <input class="btnHome" type="button" value="Return Home" onclick="returnHome()">
</form>

<script>
    function setFormMethod() {
        var form = document.getElementById("myForm");
        var method = document.getElementById("method").value;
        form.method = method;  // Cập nhật phương thức của form
    }
    function returnHome() {
        // Chuyển hướng về trang chủ mà không kiểm tra form
        window.location.href = 'returnHome';
    }
</script>

</body>
<%@include file="include/footer.jsp"%>
</html>
