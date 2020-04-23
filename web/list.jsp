<%-- 
    Document   : list
    Created on : Oct 28, 2019, 4:08:56 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4">Thông tin thành viên</h1>
                    </div>
                </div>
            <c:if test="${sessionScope.acc ne null}">
                <a class="float" href="insertMember">
                    <i class="fa fa-plus my-float"></i>
                </a>
            </c:if>





            <div class="row">
                <c:forEach items="${memberList}" var="info">
                    <div class="col-lg-4" >
                        <div class="row justify-content-center">
                            <div class="card" style="width: 18rem; margin-top: 20px;">
                                <img src="Image/${info.member.photo}" class="card-img-top" >
                                <div class="card-body">
                                    <h5 class="card-title">${info.member.gender ? "♂" : "♀"} ${info.member.name} <a href="${info.contact.facbook}" class="fa btn btn-primary  fa-facebook"></a></h5>
                                    <h6 class="card-title">${info.role.role} - Gen ${info.detail.gen}</h6>
                                    <p class="card-text">
                                        Ngày sinh : ${info.member.dob}<br/>
                                    </p></div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Ưu điểm : ${info.detail.pro}</li>
                                    <li class="list-group-item">Nhược điểm : ${info.detail.con}</li>
                                </ul>
                                <ul class ="list-group list-group-flush collapse" id="detail${info.member.id}">
                                    <li class="list-group-item">
                                        Chuyên ngành : ${info.major.name}<br/>
                                        Điện thoại : ${info.contact.phone}<br/>
                                        Email : ${info.contact.email}<br/>
                                        Địa chỉ : ${info.contact.address}</li>

                                </ul>
                                <div class ="card-body">
                                    <a href="#detail${info.member.id}" data-toggle="collapse"  class="btn btn-success" role="button" aria-expanded="false" aria-controls="detail">Chi tiết</a>
                                    <c:if test="${sessionScope.acc ne null}">
                                        <a href="updateMember?idMember=${info.member.id}" class="btn btn-warning">Chỉnh sửa</a>
                                        <a href="deleteMember?id=${info.member.id}" class="btn btn-danger">Xóa</a>
                                    </c:if>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>



        </div>

    </div>
</body>
<jsp:include page="footer.jsp"/>
</html>
