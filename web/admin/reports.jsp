<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/include/header.html" />
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="page_layout.css">
        <script src="menu_dropdown.js"></script>
        <title>TOBA- New Customer</title>
    </head>
    
<h1>Titan Online Banking</h1>

<div class="dropdown">
    <button onclick="myFunction()" class="dropbtn">Menu</button>
    <div id="myDropdown" class="dropdown-content">
        <a href="../index.jsp">HOME</a>
        <a href="../login.jsp">LOGIN</a>
        <a href="../new_customer.jsp">NEW CUSTOMER</a>
        <a href="../account_activity.jsp">ACCOUNT</a>
        <a href="../transaction.jsp">TRANSACTION</a>
        <a href="../transfer.jsp">Transfer Funds</a>
        <a href="login.html">Admin Login</a>
    </div>
</div>

<h2>Administrator Reports</h2>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Registration Date</th>
        <th>Email</th>
        <th>Username</th>
    </tr>
    <c:forEach var="u" items="${}" >
        <tr>
            <td><c:out value="${u.firstName}" /></td>
            <td><c:out value="${u.lastName}" /></td>
            <td><c:out value="${u.regiDate}" /></td>
            <td><c:out value="${u.email}" /></td>
            <td><c:out value="${u.userName}" /></td>
        </tr>
    </c:forEach>
</table>

<c:import url="/include/footer.jsp" />
