<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="include/header.jsp"%>
<body>


<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>

<form id="myForm" action="${pageContext.request.contextPath}/Ch06ex2">
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>First Name:</label>
    <input type="text" name="firstName" required><br>
    <label>Last Name:</label>
    <input type="text" name="lastName" required><br>

    <label>Heard From:</label><br>
    <div class="radio-group">
        <div class="radio-option">
            <label class="longlable">Search engine
                <input type="radio" name="heardfrom" value="Search engine">
            </label>
        </div>
        <div  class="radio-option">
            <label>Social media
                <input type="radio" name="heardfrom" value="Social media">
            </label>
        </div>
        <input type="hidden" name="action" value="add">
        <br>
    </div>
    <label>Updates:</label><br>
    <div class="radio-group">
        <div class="radio-option">
            <label>Yes
                <input type="radio" name="Update" value="Yes">
            </label>
        </div>
        <div class="radio-option">
            <label>No
                <input type="radio" name="Update" value="No">
            </label>
        </div>
        <input type="hidden" name="action" value="add">
        <br>
    </div>
    <label>Contact Via:</label><br>
    <div class="radio-group">
        <div class="radio-option">
            <label>Email
                <input type="radio" id="Email" name="contactvia" value="Email">
            </label>
        </div>
        <div class="radio-option">
            <label>Other
                <input type="radio" id="Other" name="contactvia" value="Other">
            </label>
        </div>
        <input type="hidden" name="action" value="add">
        <br>
    </div>
    <div class="method">
        <select id="method" name="method" onchange="setFormMethod()">
            <option value="GET">GET</option>
            <option value="POST">POST</option>
        </select>
        <label for="method">Choose method:</label>
        <button class="button" type="submit">Submit</button>
    </div>
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

