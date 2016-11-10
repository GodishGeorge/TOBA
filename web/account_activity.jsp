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


<c:import url="/includes/footer.jsp" />