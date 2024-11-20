<%@include file="include/header.jsp"%>
<!DOCTYPE html>
<html>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>

<form id="myForm" action="Ch08ex1" method="get">
    <input type="hidden" name="action" value="add">

    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>First Name:</label>
    <input type="text" name="firstName" required><br>
    <label>Last Name:</label>
    <input type="text" name="lastName" required><br>
    <input type="hidden" name="action" value="add">

    <label>&nbsp;</label>
    <input class="button" type="submit" value="Join Now" id="submit">
    <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()">
</form>
<script>
    function returnHome() {
        // Chuyển hướng về trang chủ mà không kiểm tra form
        window.location.href = 'returnHome';
    }
</script>
</body>

<%@include file="include/footer.jsp"%>
</html>
