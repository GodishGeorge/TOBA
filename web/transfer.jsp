<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />

</div>
    
    <h2>Transfer Money</h2>
    <p>Checking Account Balance:</p> ${user.getCheckingBal()}
    <p>Savings Account Balance:</p> ${user.getSavingsBal()}
    
    <form action="TransactionServlet" method="post">
        <p><font color="red"><b><i>${message}</i></b></font></p>
        <label>Transfer from:</label>
        <input type="radio" name="account" value="checking1"> Checking
        <input type="radio" name="account" value="savings2"> Savings<br>
        <Label>Transfer to:</label>
        <input type="radio" name="account" value="checking2"> Checking
        <input type="radio" name="account" value="savings2"> Savings<br>
        <label>Enter amount:</label>
        <input type="text" name="amount" required><br>
        <input type="submit" value="Submit">
    </form>
    
    
<c:import url="/includes/footer.jsp" />

