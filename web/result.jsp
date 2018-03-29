<%-- 
    Document   : result
    Created on : Mar 29, 2018, 2:27:25 PM
    Author     : PHUONGTHUAN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Products</title>
    </head>
    <body>
        <h1>Product List</h1>
        
        <a href="search.jsp" >Search</a>
        
        <jsp:useBean class="com.ecm.models.ProductFinderBean" id="finder" scope="request"/>

        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Description</td>
            </tr>
            
        <c:forEach items="${finder.products}" var="product">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.description}" /></td>
            </tr>
        </c:forEach>
        </table>
        
    </body>
</html>
