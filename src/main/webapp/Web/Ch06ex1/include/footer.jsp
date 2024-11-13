<footer>
    <%--    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
    <%
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);
    %>
    <p>&copy; Copyright ${currentYear} Mike Murach &amp; Associates</p>
</footer>