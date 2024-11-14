<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:import url="include/header.jsp"/>
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

<form action="Ch08ex1" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
</body>
<c:if test="${not empty sessionScope.users}">
    <c:forEach var="user" items="${sessionScope.users}" varStatus="status">
        <c:if test="${status.index < 2}">
            <p>User ${status.index + 1}: <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></p>
        </c:if>
    </c:forEach>
</c:if>
<p>Customer Service Email: ${initParam.custServEmail}</p>
<%@include file="include/footer.jsp"%>
</html>
