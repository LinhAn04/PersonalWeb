<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

<form action="${pageContext.request.contextPath}/JavaMail" method="post">
  <input type="hidden" name="action" value="join">
  <input type="submit" value="Return">
</form>
</body>

<form action="returnHome" method="get">
  <input class="btnHome" type="submit" value="Return Home" id="home">
</form>

<%@include file="include/footer.jsp"%>
</html>
