<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/include/header.html" />

<h1>Titan Online Banking</h1>

<h2>Administrator Reports</h2>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Registration Date</th>
        <th>Email</th>
        <th>Username</th>
    </tr>
    <c:forEach var="userMonthlyReports" items="${userMonthlyReports}" >
        <tr>
            <td><c:out value="${userMonthlyReports.firstName}" /></td>
            <td><c:out value="${userMonthlyReports.lastName}" /></td>
            <td><c:out value="${userMonthlyReports.regiDate}" /></td>
            <td><c:out value="${userMonthlyReports.userName}" /></td>
        </tr>
    </c:forEach>
</table>

<c:import url="/include/footer.jsp" />
