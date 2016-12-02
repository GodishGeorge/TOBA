<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />

    <h2>Account successfully created!</h2>

    <p>Welcome ${user["firstName"]} ${user["lastName"]}</p>
    <p>You have entered the following:<br>
        Phone: ${user["phone"]}<br>
        Address: ${user["address"]}<br>
        City: ${user["city"]}<br>
        State: ${user["state"]}<br>
        Zip Code: ${user["zipcode"]}<br>
        Email: ${user["email"]}<br>
        Username: ${user["userName"]}<br>
        Password: ${user["password"]}</p>
    <p>Return to Titan <a href="index.html">Home</a></p>
</div>

<c:import url="/includes/footer.jsp" />