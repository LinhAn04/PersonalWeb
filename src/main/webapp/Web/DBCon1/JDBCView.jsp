<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="include/header.jsp"%>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatement == null}">
  <c:set var="sqlStatement" value="select * from DocGia" />
</c:if>

<h1>The SQL Gateway</h1>
<p>Enter an SQL statement and click the Execute button.</p>
<p><b>SQL statement:</b></p>

<form action="SQLGateway" method="get">
  <textarea name="sqlStatement" cols="60" rows="8">
    ${sqlStatement}
  </textarea>
  <input class="button" type="submit" value="Execute">
  <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()"><br>
</form>

<script>
  function returnHome() {
    // Chuyển hướng về trang chủ mà không kiểm tra form
    window.location.href = 'returnHome';
  }
</script>

<p><b>SQL result:</b></p>
${sqlResult}

</body>
<%@include file="include/footer.jsp"%>
</html>
