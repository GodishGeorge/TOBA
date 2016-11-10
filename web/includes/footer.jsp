<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
Calendar currentDate = new GregorianCalendar();
int currentYear = currentDate.get(Calendar.YEAR);
int currentMonth = currentDate.get(Calendar.MONTH) + 1;
int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
%>

<footer>
<p>&copy; Copyright <%= currentMonth + "/" + currentDay + "/" + currentYear %> Titan Online Banking</p>
</footer>
</body>
</html>

