<%-- 
    Document   : home.jsp
    Created on : Nov 1, 2019, 8:05:16 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="jumbotron">
                <h1 class="display-4">Đăng nhập</h1>
                <hr class="my-4"/>
                <c:if test="${param.err ne null}">
                    <div class="btn btn-danger">Sai tài khoản hoặc mật khẩu</div>
                </c:if>
            </div>
            <div class="row">
                <div class="col-lg-4"></div>
                <form class="col-lg-4" method="POST" action="login">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Tài khoản</label>
                        <input name="username" type="text" class="form-control" placeholder="Nhập tài khoản">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Mật khẩu</label>
                        <input name="password" type="password" class="form-control" placeholder="Nhập mật khẩu">
                    </div>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
                
                <div class="col-lg-4"></div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
