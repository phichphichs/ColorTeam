<%-- 
    Document   : deleteEvent
    Created on : Nov 10, 2019, 9:27:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Xóa sự kiện</h1>
                    </div>
                </div>
               

                <form action="deleteEvent" method="POST">
                    <input type="text" name="id" value="${event.id}" hidden="">
                <div class="form-group row">
                    <label class="col-lg-2">Sự kiện:</label>
                    <input class="form-control col-lg-10" type="text" name="name" value="${event.name}">
                </div>
                <div class="form-group row">
                    <label class="col-lg-2"> Thể loại:</label>
                    <input class="form-control col-lg-10" type="text" name="genre" value="${event.genre}">
                </div>
                <div class="form-group row">
                    <label class="col-lg-2"> Thời gian: </label>
                    <input class="form-control col-lg-10" type="text" name="time" value="${event.time}">
                </div>
                <input type="submit" name="btnDelete" value="Xóa"  class="btn btn-outline-primary">
            </form>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
