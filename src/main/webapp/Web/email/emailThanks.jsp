<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Murach's Java Servlets and JSP</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/email/email.css" type="text/css"/>
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

<form action="" method="post">
  <input type="hidden" name="action" value="join">
  <input type="submit" value="Return">

  <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()">

</form>

<script>
  function returnHome() {
    // Chuyển hướng về trang chủ mà không kiểm tra form
    window.location.href = 'returnHome';
  }
</script>

</body>
</html>
