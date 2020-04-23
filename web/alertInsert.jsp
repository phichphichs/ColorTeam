<%-- 
    Document   : alertInsert
    Created on : Nov 10, 2019, 11:01:15 PM
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
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Thêm thành viên mới thành công rồi!!!</h4>
                <p>Aww yeah, vậy là Color Team đã có thêm thành viên mới vào tổ chức của chúng mình ! </p>
                <hr>

            </div>
            Click vào đây để quay về 
            <button type="button" class="btn btn-outline-primary">
                <a class="nav-link" href="list">Trang chủ
                </a>
            </button>
        </div>

    </body>
    <jsp:include page="footer.jsp"/>
</html>
