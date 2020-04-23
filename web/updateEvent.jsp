<%-- 
    Document   : updateEvent
    Created on : Nov 6, 2019, 10:13:12 PM
    Author     : User
--%>


<%@page import="model.Event_Detail"%>
<%@page import="model.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <style>
            .card {
                border-radius: 0px !important;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Cập nhật sự kiện</h1>
                    </div>
                </div>

                <form action="updateEvent" method="POST">
                    <input type="text" name="idEvent" value="${event.id}" hidden="">
                <div class="form-group row">
                    <label class="col-lg-2">  Tên sự kiện:</label>
                    <input class="form-control col-lg-10 text-info" type="text" name="name" value="${event.name}"/>
                </div>
                <div class="form-group row">
                    <label class="col-lg-2">   Thể loại:</label>
                    <input class="form-control col-lg-10 text-info" type="text" name="genre" value="${event.genre}"/>
                </div>
                <div class="form-group row">
                    <label class="col-lg-2">Thời gian:</label>
                    <input class="form-control col-lg-10 text-info" type="date" name="time" value="${event.time}"/>
                </div>

                <div class="form-group row">
                    <label class="col-lg-2"> Mục đích: </label>
                    <input class="form-control col-lg-10 text-info" type="text" name="purpose" value="${detail.purpose}"/>
                </div>

                <div class="form-group row">
                    <label class="col-lg-2">Nội dung:</label>
                    <input class="form-control col-lg-10 text-info" type="text" name="content" value="${detail.content}"/>
                </div>

                <div class="row">
                    <button class="btn btn-success" type="submit" > Lưu </button>
                </div>

                <div class="row">
                    <label class="badge badge-info col-lg-12 "><h4>Thành viên: </h4></label>
                    <!--<div class="btn-group-toggle" data-toggle="buttons">-->
                    <c:forEach items="${membersEvent}" var="m">
                        <div class=" col-lg-2">
                            <div class="card" >
                                <img src="Image/${m.photo}" class="card-img-top" />
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><b>${m.name}</b></li>
                                    <li class="list-group-item"><input  class="form-control" type="checkbox" name="idMember" value="${m.id}" checked> </li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>  
                    <c:forEach items="${memberNotInEvent}" var="m">

                        <div class="col-lg-2">
                            <div class="card" >
                                <img src="Image/${m.photo}" class="card-img-top" />
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><b>${m.name}</b></li>
                                    <li class="list-group-item"><input  class="form-control" type="checkbox" name="idMember" value="${m.id}"> </li>
                                </ul>
                            </div>
                        </div>

                    </c:forEach>  

                </div>
                <div class="row">
                    <button class="btn btn-success" type="submit" > Lưu </button>
                </div>

            </form>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
