<%-- 
    Document   : search
    Created on : Mar 29, 2018, 2:27:25 PM
    Author     : PHUONGTHUAN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <h1>Product List</h1>
        <form action="ProductFinder">
            <span>
                <c:out value="${param.msg}"></c:out>
            </span>
            
            <input name="name" />
            <input type="submit" value="Submit" />
        </form>
            
    </body>
</html>
