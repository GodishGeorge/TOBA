<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="page_layout.css">
        <link rel="stylesheet" type="text/css" href="new_customer_form.css">
        <script src="menu_dropdown.js"></script>
        <title>TOBA- New Customer</title>
    </head>
    <body>
        <div>
            <h1>Titan Online Banking</h1>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn">Menu</button>
                <div id="myDropdown" class="dropdown-content">
                    <a href="index.html">HOME</a>
                    <a href="login.html">LOGIN</a>
                    <a href="new_customer.jsp">NEW CUSTOMER</a>
                    <a href="account_activity.html">ACCOUNT</a>
                    <a href="transaction.html">TRANSACTION</a>
                </div>
            </div>
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
                           height: 3em; font-size: 16px">
                </div>
            </form>
        </div>
    </body>
</html>
