<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />
</div>

<br><br><br>
<h2>Sign in or <a href="new_customer.jsp">Register</a></h2>

<form action="login" method="post">
    <label>Username</label>
    <input type="text" name="Username" required>
    <label>Password</label>
    <input type="password" name="Password" required>
    <input type="hidden" name="action" value="register">
    <input type="submit" value="Sign In">
</form>
<p><a href="password_reset.jsp">Reset Password</a></p>

<c:import url="/includes/footer.jsp" />