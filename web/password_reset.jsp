<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div>
    <h1>Titan Online Banking</h1>
    <c:import url="/includes/navigation.jsp" />
</div>

<form action="reset_password" method="post">
    <h3>Please enter all fields</h3>
    <p><font color="red"><b><i>${message}</i></b></font></p>
    <label>User Name:</label>
    <input type="text" name="userName" required>
    <label>Old Password:</label>
    <input type="password" name="oldPassword" required>
    <label>New Password:</label>
    <input type="password" name="newPassword" value="${user.password}" required>
    <label>Confirm Password</label>
    <input type="password" name="confirmPassword" required><br>
    <input type="submit" name="Reset" style="width: 6em; 
           height: 3em; font-size: 16px; margin-top: 30px">
</form>

<c:import url="/includes/footer.jsp" />