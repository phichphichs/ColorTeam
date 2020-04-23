<%-- 
    Document   : deleteEvent
    Created on : Nov 10, 2019, 8:51:23 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <form action="deleteEvent" method="POST">
            <h3>
                Có phải bạn muốn xóa sự kiện ${event.name} không?
            </h3>
            <input type="submit" value="Delete">
            
        </form>
    </body>
</html>
