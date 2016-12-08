<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />

</div>

<c:if test="${user != null}">
    <p>Welcome ${user.firstName} ${user.lastName}</p>
</c:if>
<c:if test="${user == null}">
    <p>You are not logged in!</p>
</c:if>
<p><font color="red"><b><i>${message}</i></b></font></p>

<h2>Account Information</h2>
<p>Checking Balance:</p> ${checking.balance}
<p>Savings Balance</p> ${savings.balance}

<h2>Past Transactions</h2>
<table>
    <tr>
        <th>Transfer Type</th>
        <th>Transfer Amount</th>
        <th>Transaction ID</th>
    </tr>
    <c:forEach var="savingsTrans" items="${savingsList}" >
        <tr>
            <td><c:out value="${savingsTrans.type}" /></td>
            <td><c:out value="${savingsTrans.transAmount}" /></td>
            <td><c:out value="${savingsTrans.tranactionID}" /></td>
        </tr>
    </c:forEach>
</table>



<c:import url="/includes/footer.jsp" />