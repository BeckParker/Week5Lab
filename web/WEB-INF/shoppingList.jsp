<%-- 
    Document   : shoppingList
    Created on : Oct 11, 2017, 1:39:41 PM
    Author     : 679810
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>
            Hello, ${username} 
            <a href="ShoppingList?action=logout">Log out</a>
        </p>
        <h2>List</h2>
        <form method="POST">
            <input type="hidden" name="action" value="add">
            Add Item: <input type="text" name="item">
            <input type="submit" value="Add">
        </form>
        <c:if test="${sessionScope.list != null}">
            <form method="POST">
                <input type="hidden" name="action" value="delete">
                <c:forEach items="${sessionScope.list}" var="item" varStatus="status">
                    <input type="radio" name="selected" value="${status.index}"> ${item}<br>
                </c:forEach>
                    <input type="submit" value="delete">
                </form>
        </c:if>
        
    </body>
</html>
