<%-- 
    Document   : listEvent
    Created on : Oct 31, 2019, 12:55:26 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    </head>
    <body>



        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Sự kiện</h1>
                    </div>
                </div>
            <c:if test="${sessionScope.acc ne null}">
                <a class="float" href="insertEvent">
                    <i class="fa fa-plus my-float"></i>
                </a>
            </c:if>



            <div class="row">


                <c:forEach items="${events}" var="e">
                    <div class="col-lg-1"></div>
                    <div class="jumbotron col-lg-10">
                        <div class="container">
                            <h1 class="display-4">${e.event.name} </h1>
                            <div class="embed-responsive embed-responsive-16by9">
                                <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${e.detail.video}" allowfullscreen></iframe>
                            </div>
                            <p class="lead"><h3>${e.detail.purpose}</h3></p>
                            <span class="badge badge-pill badge-primary"><fmt:formatDate pattern="dd-MM-yyyy" value="${e.event.time}"/></span>
                            <span class="badge badge-pill badge-success">${e.event.genre} </span>
                            <hr class="my-4">

                            <p>Nội dung: <a href="${e.detail.content}">${e.detail.content}</a>
                            <p>
                                <c:if test="${sessionScope.acc ne null}">
                                    <a class="btn btn-success btn-md" href="updateEvent?idEvent=${e.event.id}" role="button">Update</a>
                                    <a class="btn btn-danger btn-md" href="deleteEvent?id=${e.event.id}" role="button">Delete</a>
                                </c:if>
                        </div>
                    </div>
                    <div class="col-lg-1"></div>

                </c:forEach>

            </div>

        </div>


    </body>
    <jsp:include page="footer.jsp"/>
</html>
