<%-- 
    Document   : contact
    Created on : Oct 28, 2019, 6:36:25 AM
    Author     : User
--%>

<%@page import="model.Role_Member"%>
<%@page import="model.Member_Contact"%>
<%@page import="model.Member_Detail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%

            ArrayList<Member_Contact> member_Contacts = (ArrayList<Member_Contact>) request.getAttribute("member_Contacts");
            Member_Contact c = (Member_Contact) request.getAttribute("contact");
            Role_Member rm = (Role_Member) request.getAttribute("roleById");
            Member m = (Member) request.getAttribute("memberById");

        %>
    </head>
    <body>
        <h1>Thông Tin Liên Lạc</h1>


        <img src="Image/<%=m.getPhoto()%>" width="500" height="500"> <br>
        ID :  <%=m.getId()%> <br>
        Tên :<%=m.getName()%><br>
        NickName : <%=c.getNickname()%><br>
        Phone <: <%=c.getPhone()%><br>
        Address <: <%=c.getAddress()%><br>
        Mail : <%=c.getEmail()%><br>
        Facebook: <a href='<%=c.getFacbook()%>'><%=c.getFacbook()%></a>





        <h3> <a href='list'>Comeback to first page </a></h3>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
