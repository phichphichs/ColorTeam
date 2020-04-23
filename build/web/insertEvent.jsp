<%-- 
    Document   : insertEvent
    Created on : Nov 4, 2019, 7:49:56 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Thêm sự kiện</h1>
                    </div>
                </div>
               

                <div class="container">

                    <form action="insertEvent" method="post">
                        <input name="id" value="${member.id}" hidden>
                    <div class="form-group row">
                        <label class="col-lg-2">Sự kiện:</label>
                        <input class="form-control col-lg-10" type="text" required="" name="name">
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2"> Thể loại:</label>
                        <input class="form-control col-lg-10" type="text" name="genre" >
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">  Thời gian</label>
                        <input class="form-control col-lg-10" type="date" name="time" >
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Mục đích</label>
                        <input class="form-control col-lg-10" type="text" name="purpose"><br>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Nội dung</label>
                        <input class="form-control col-lg-10" type="text" name="content"><br>
                    </div>
                 

                    <input type="submit" value="Thêm"  class="btn btn-outline-primary">
                </form>
            </div>
        </div>


    </body>
    <jsp:include page="footer.jsp"/>
</html>
