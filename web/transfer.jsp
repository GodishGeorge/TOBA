<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div>
    <h1>Titan Online Banking</h1>

    <c:import url="/includes/navigation.jsp" />

</div>
    
    <h2>Transfer Money</h2>
    <p>Checking Account Balance: $</p> ${checking.balance}
    <p>Savings Account Balance: $</p> ${savings.balance}
    
    
    <form action="transaction" method="post">
        <p><font color="red"><b><i>${message}</i></b></font></p>
        <label>Transfer from:</label>
        <select name="from">
            <option name="checkingFrom">Checking</option>
            <option name="savingsFrom">Savings</option>
        </select><br>
        <Label>Transfer to:</label>
        <select name="to">
            <option name="checkingTo">Checking</option>
            <option name="savingsTo">Savings</option>
        </select><br>
        <label>Enter amount:</label>
        <input type="number" name="amount" placeholder="0" value="${amount}" required><br>
        <input type="submit" value="Submit">
    </form>
    
    
<c:import url="/includes/footer.jsp" />

