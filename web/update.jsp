<%-- 
    Document   : update
    Created on : Oct 29, 2019, 8:46:01 AM
    Author     : User
--%>

<%@page import="model.Member_Contact"%>
<%@page import="model.Member_Detail"%>
<%@page import="model.Member"%>
<%@page import="model.Role_Member"%>
<%@page import="model.Major"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4 text-center text-success">Chỉnh sửa thành viên</h1>
                    </div>
                </div>


                <div class="container">
                <c:if test="${param.msg ne null}"> <p class="btn btn-success">${param.msg}</p> </c:if>
                    <form action="updateMember" method="post">
                        <input name="id" value="${member.id}" hidden>
                    <div class="form-group row">
                        <label class="col-lg-2">Họ và tên</label>
                        <input class="form-control col-lg-10" type="text" name="name" value="${member.name}"/>
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Ngày sinh</label>
                        <input class="form-control col-lg-10" type="date" name="dob" value="${member.dob}"/>
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Giới tính</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="1" ${member.gender ? "checked" : ""}/>
                            <label class="form-check-label">Nam</label>

                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="0" ${!member.gender  ? "checked" : ""}/>
                            <label class="form-check-label">Nữ</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Ngành học</label>
                        <select name="major" class="col-lg-10 form-control">
                            <c:forEach items="${majors}" var="ma">
                                <option value="${ma.id}" ${ma.id == member.idMajor ? "selected" : ""}>
                                    ${ma.name}
                                </option>
                            </c:forEach> 

                        </select>

                    </div>
                    <div class="form-group row">
                        <label class="col-lg-2">Chức vụ</label>
                        <select name="role" class="col-lg-10 form-control">
                            <c:forEach items="${roles}" var="r">
                                <option value="${r.id}" ${r.id == detail.idRole ? "selected" : ""}>
                                    ${r.role}
                                </option>
                            </c:forEach> 

                        </select>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2"> Gen </label>
                        <input class="form-control col-lg-10" type="text" name="gen" value="${detail.gen}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Ưu điểm</label>
                        <input class="form-control col-lg-10" type="text" name="pro" value="${detail.pro}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Nhược điểm</label>
                        <input class="form-control col-lg-10" type="text" name="con" value="${detail.con}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Biệt danh</label>
                        <input class="form-control col-lg-10" type="text" name="nickname" value="${contact.nickname}"/>
                    </div>
                    <div class="form-group row">

                        <a  class="fa  fa-facebook col-lg-2"></a>
                        <input class="form-control col-lg-10" type="text" name="fb" value="${contact.facbook}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Địa chỉ</label>
                        <input class="form-control col-lg-10" type="text" name="address" value="${contact.address}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Phone</label>
                        <input class="form-control col-lg-10" type="text" name="phone" value="${contact.phone}"/>
                    </div>

                    <div class="form-group row">
                        <label class="col-lg-2">Email</label>
                        <input class="form-control col-lg-10" type="text" name="mail" value="${contact.email}"/>
                    </div>
                    <input type="submit" value="Update" name="Update"  class="btn btn-outline-primary">
                </form>
            </div>




        </div>
    </div>

</body>
<jsp:include page="footer.jsp"/>
</html>
