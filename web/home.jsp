<%-- 
    Document   : home.jsp
    Created on : Nov 1, 2019, 8:05:16 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            .carousel-item {
                background-color: #e9ecef;
            }
        </style>
    </head>
    <body>

        <jsp:include page="header.jsp"/>
        <div class="container">

        <section>
            <div class="container">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="Image/1.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h5>Cùng bàn về</h5>
                                    <p>Những người dẫn đầu</p>
                                </div>
                            </div>
                        </div>

                        <div class="carousel-item">
                            <img src="Image/lead1.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Nguyễn Việt Linh</h3>
                                    <p>Người sáng lập Color Team</p>
                                </div>
                            </div>
                        </div>

                        <div class="carousel-item">
                            <img src="Image/ct_congxam.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Nguyễn Văn Công</h3>
                                    <p>Leader chuyền cần nhất </p>
                                </div>
                            </div>
                        </div>


                        <div class="carousel-item">
                            <img src="Image/ct_oanhkluong.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Oanh K Lương</h3>
                                    <p>Leader ngầu nhất ĐH FPT</p>
                                </div>
                            </div>
                        </div>



                        <div class="carousel-item">
                            <img src="Image/lead2.jpg" width="600" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Lê Hoàng Anh Dũng</h3>
                                    <p>Leader vừa ham chơi vừa ham làm </p>
                                    <p>nhất Vịnh Bắc Bộ</p>
                                </div>
                            </div>
                        </div>


                        <div class="carousel-item">
                            <img src="Image/hinh.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Nguyễn Phương Anh</h3>
                                    <p>Leader style nhất Vịnh Bắc Bộ</p>
                                </div>
                            </div>
                        </div>

                        <div  class="carousel-item">
                            <img src="Image/leadnow.jpg" width="500" height="500">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="text-right text-body">
                                    <h3>Đoàn Thúy Hằng</h3>
                                    <p>Leader tấu hài nhất hệ Mặt Trời</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </section>


        <section>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 order-lg-2">
                        <div class="p-5">
                            <img class="img-fluid rounded-circle" src="Image/NEO_8786.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="p-5">
                            <h2 class="display-4">  <a class="nav-link" href="https://www.facebook.com/colorteamvn/">Về chúng tôi </a></h2>
                           
                                 <p>Sinh ra để làm màu</p>
                            
                           
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 ">
                        <div class="p-5">
                            <img class="img-fluid rounded-circle" src="Image/waterday2019.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 order-lg-1">
                        <div class="p-5">
                            <h2 class="display-4"> <a class="nav-link" href="listEvent">Sự kiện nổi bật</a></h2>
                            <p>Color Team tổ chức các chương trình dạy kỹ năng mềm cho các em nhỏ, tạo game cho các sự kiện</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
