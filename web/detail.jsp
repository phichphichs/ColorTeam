<%-- 
    Document   : detail
    Created on : Oct 28, 2019, 6:01:13 AM
    Author     : User
--%>

<%@page import="model.Member_Contact"%>
<%@page import="model.Role_Member"%>
<%@page import="model.Member_Detail"%>
<%@page import="model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%

          
            Member_Detail d = (Member_Detail) request.getAttribute("detail");
            Role_Member rm = (Role_Member) request.getAttribute("roleById");
            Member m = (Member) request.getAttribute("memberById");
        %>

    </head>
    <body>
        <h1>Thông tin chi tiết</h1>




        <img src="Image/<%=m.getPhoto()%>" width="500" height="500"> <br>

        ID: <%=m.getId()%> <br>
       
        Tên: <%=m.getName()%> <br>
        Chức vụ: <%=rm.getRole()%> <br>
        ColorTeam đời thứ: <%=d.getGen()%> <br>
        Ưu điểm: <%=d.getPro()%> <br>
        Nhược điểm: <%=d.getCon()%> <br>

    <td><a href='contact?id=<%=d.getIdMember()%>'>Contact</td>


</body>
<jsp:include page="footer.jsp"/>
</html>
