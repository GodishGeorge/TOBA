<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<link rel="stylesheet" type="text/css" href="new_customer_form.css">

<div>
    <h1>Titan Online Banking</h1>
    <c:import url="/includes/navigation.jsp" />
</div>

<div>
    <form action="new_customer" method="post">
        <p><font color="red"><b><i>${message}</i></b></font></p>
        <div class="sub_entry">
            <input type="hidden" name="action" value="add">
            <label>First Name:</label>
            <input type="text" name="firstName">
            <label>Last Name:</label>
            <input type="text" name="lastName">
            <label>Phone:</label>
            <input type="text" name="phone">
            <label>Address:</label>
            <input type="text" name="address">
        </div>
        <div class="sub_entry">
            <label>City:</label>
            <input type="text" name="city">
            <label>State:</label>
            <input type="text" name="state">
            <label>Zip Code:</label>
            <input type="text" name="zipcode">
            <label>Email:</label>
            <input type="text" name="email"> 
        </div>
        <div class="margin_left">
            <input type="submit" value="Register" style="width: 6em; 
                   height: 3em; font-size: 16px; margin-top: 30px">
        </div>
    </form>
</div>

<c:import url="/includes/footer.jsp" />