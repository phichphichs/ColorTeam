<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">



<style>
    .float{
        position:fixed;
        width:60px;
        height:60px;
        bottom:40px;
        right:10px;
        background-color:#0C9;
        color:#FFF;
        border-radius:50px;
        text-align:center;
        box-shadow: 2px 2px 3px #999;
    }
    .my-float{
        margin-top:22px;
        z-index: 0;
    }
    body {
        /*background-color: #f8f9fa!important;*/
    }
</style>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg ">
    <a class="navbar-brand" href="home.jsp"> 
        <img src="Image/chuCT_1.png" width="180" height="100">   
    </a>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="home.jsp"> 
        <img src="Image/chuCT_1.png" width="180" height="100">   
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto ustify-content-end">

            <li class="nav-item">
                <a class="nav-link" href="home.jsp">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="list">Member</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="listEvent">Event</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://www.facebook.com/colorteamvn/">Color Team</a>
            </li>
            <li class="nav-item">

                <c:if test="${sessionScope.acc eq null}">
                    <a class="btn btn-success" href="login">Login</a>  
                </c:if>
                <c:if test="${sessionScope.acc ne null}">
                    <a class="btn btn-danger" href="logout">Logout</a> 
                </c:if>
            </li>


        </ul>
        
    </div>
    
</nav>


<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="Image/colorTrip.jpg" class="d-block w-100"  alt="...">
        </div>

    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<hr/>