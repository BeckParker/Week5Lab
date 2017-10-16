<%-- 
    Document   : register
    Created on : Oct 11, 2017, 1:39:12 PM
    Author     : 679810
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register Account:</h1>
        <br>
        <form method="POST">
            <input type="hidden" name="action" value="register">
            Username: <input type="text" name="name">
            <input type="submit" value="Register">
        </form>
        ${error}
    </body>
</html>
