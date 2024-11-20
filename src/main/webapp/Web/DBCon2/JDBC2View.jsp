<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="include/header.jsp"%>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and email address below.</p>
<p><i>${message}</i></p>

<form action="DBCon2" method="post">
  <input type="hidden" name="action" value="add">
  <label class="pad_top">Email:</label>
  <input type="email" name="email" value="${user.email}" required><br>
  <label class="pad_top">First name:</label>
  <input type="text" name="firstName" value="${user.firstName}" required><br>
  <label class="pad_top">Last name:</label>
  <input type="text" name="lastName" value="${user.lastName}" required><br>
  <label>&nbsp</label>
  <input class="button" type="submit" value="Join Now">
  <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()"><br>
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
