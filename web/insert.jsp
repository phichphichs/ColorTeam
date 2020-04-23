<%-- 
    Document   : insert
    Created on : Oct 29, 2019, 1:53:46 AM
    Author     : User
--%>

<%@page import="model.Role_Member"%>
<%@page import="model.Member"%>
<%@page import="model.Major"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <%
            ArrayList<Major> majors = (ArrayList<Major>) request.getAttribute("majors");
            ArrayList<Role_Member> roles = (ArrayList<Role_Member>) request.getAttribute("roles");

        %>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Thêm thành viên mới</h1>
                    </div>
                </div>
                <a class="float" href="insertMember">
                    <i class="fa fa-plus my-float"></i>
                </a>




                <form action="insertMember" method="POST">


                    <div class="form-group row">
                        <label class="col-lg-2">ID</label>
                        <input class="form-control col-lg-10 text-info" type="number" name="idMember" required=""/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">  Tên thành viên:</label>
                        <input class="form-control col-lg-10 text-info" type="text" name="name" required=""/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Ngày sinh</label>
                        <input class="form-control col-lg-10" type="date" name="dob"  required="" />
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Giới tính</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="1"  required="" />
                            <label class="form-check-label">Nam</label>

                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="0" />
                            <label class="form-check-label">Nữ</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Ngành học</label>
                        <select name="major" class="col-lg-10 form-control">
                        <% for (Major m : majors) {%>
                        <option value="<%=m.getId()%>"  >
                            <%=m.getName()%>  
                        </option>  
                        <%}%>
                    </select><br>
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Chức vụ: </label>
                    <select name="role" class="col-lg-10 form-control">
                        <% for (Role_Member r : roles) {%>
                        <option value="<%=r.getId()%>"  >
                            <%=r.getRole()%>  
                        </option>  
                        <%}%>
                    </select><br>
                </div>

                <div class="form-group row">
                    <label class="col-lg-2"> Gen </label>
                    <input class="form-control col-lg-10" type="text" name="gen"/>
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Ưu điểm</label>
                    <input class="form-control col-lg-10" type="text" name="pro" />
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Nhược điểm</label>
                    <input class="form-control col-lg-10" type="text" name="con" />
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Biệt danh</label>
                    <input class="form-control col-lg-10" type="text" name="nickname"/>
                </div>
                <div class="form-group row">

                    <a  class="fa  fa-facebook col-lg-2"></a>
                    <input class="form-control col-lg-10" type="text" name="fb" />
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Địa chỉ</label>
                    <input class="form-control col-lg-10" type="text" name="address" />
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Phone</label>
                    <input class="form-control col-lg-10" type="text" name="phone" />
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Email</label>
                    <input class="form-control col-lg-10" type="text" name="mail" />
                </div>

                <input type="submit" value="Insert" class="btn btn-outline-primary">

            </form>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
