<%-- 
    Document   : delete
    Created on : Oct 30, 2019, 1:47:42 AM
    Author     : User
--%>

<%@page import="model.MembelRoleDetailContact"%>
<%@page import="model.Member_Contact"%>
<%@page import="model.Member_Detail"%>
<%@page import="model.Member"%>
<%@page import="model.Role_Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Major"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Member m = (Member) request.getAttribute("member");
            Role_Member role = (Role_Member) request.getAttribute("role");
            Major major = (Major) request.getAttribute("major");
            Member_Contact c = (Member_Contact) request.getAttribute("mc");
            Member_Detail d = (Member_Detail) request.getAttribute("md");
        %>   
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Xóa thành viên</h1>
                    </div>
                </div>
              

                <form action="deleteMember" method="POST">

                    <input type="number" name="id" value="<%=m.getId()%>" hidden="" ><br>
                <div class="form-group row">
                    <label class="col-lg-2">Tên thành viên</label>
                    <input class="form-control col-lg-10" type="text" name="name" value="<%=m.getName()%>">
                </div>


                <div class="form-group row">
                    <label class="col-lg-2">Ngày tháng năm sinh</label>
                    <input class="form-control col-lg-10" type="date" name="dob" value="<%=m.getDob()%>">
                </div>


                <div class="form-group row">
                    <label class="col-lg-2">Giới tính</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="1" <%=m.isGender() ? "checked" : ""%>>
                        <label class="form-check-label">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="0"  <%=!m.isGender() ? "checked" : ""%>>
                        <label class="form-check-label">Nữ</label>
                    </div>
                </div>

                  <div class="form-group row">
                    <label class="col-lg-2">Chức vụ</label>
                    <input class="form-control col-lg-10" type="text" value="<%=role.getRole()%>">
                </div>

                <input type="submit" value="Xóa" name="Delete"  class="btn btn-outline-primary">

            </form>

    </body>
    <jsp:include page="footer.jsp"/>
</html>
