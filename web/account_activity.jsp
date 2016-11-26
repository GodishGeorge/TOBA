<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />

</div>

<c:if test="${sessionScope.user != null}">
    <p>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
</c:if>
<c:if test="${user == null}">
    <p>You are not logged in!</p>
</c:if>
<p><font color="red"><b><i>${message}</i></b></font></p>

 <h2>Account Information</h2>
    <table>
        <tbody>
            <tr>
                <th>User Name</th>
                <td>${sessionScope.user.userName}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${sessionScope.user.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${sessionScope.user.lastName}</td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>${sessionScope.user.phone}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${sessionScope.user.address}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${sessionScope.user.city}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${sessionScope.user.state}</td>
            </tr>
            <tr>
                <th>ZIP Code</th>
                <td>${sessionScope.user.zipCode}</td>
            </tr>
            <tr>
                <th>Email Address</th>
                <td>${sessionScope.user.email}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${sessionScope.user.password}</td>
            </tr>
        </tbody>
    </table>
    <h2>Accounts</h2>
    <table>
        <thead>
            <tr>
                <th>Account Type</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${sessionScope.accounts}">
                <tr>
                    <td>${account.accountType}</td>
                    <td><fmt:formatNumber type="currency" currencySymbol="$" value="${account.balance}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Transactions</h2>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Account</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${sessionScope.accounts}">
                <c:forEach var="transaction" items="${account.transactions}">
                    <tr>
                        <td>${account.accountType}</td>
                        <td><fmt:formatNumber type="currency" currencySymbol="$" value="${transaction.amount}" /></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>


<c:import url="/includes/footer.jsp" />