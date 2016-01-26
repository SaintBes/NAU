<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.fancybox.js"></script>
    <script src="../js/jquery.fancybox.pack.js"></script>
    <script src="../js/jquery.rating.js"></script>

    <script type="text/javascript">
        $(function(){

            rate = $("#rate").val;
            rateId = $("#rateId").val;

            $('#rating_1').rating({
                fx: 'full',
                image: 'img/stars.png',
                loader: 'img/ajax-loader.gif',
                width: 32,
                url: '#'
            });

            $('#rating_2').rating({
                fx: 'half',
                image: 'img/stars.png',
                loader: 'img/ajax-loader.gif',
                width: 32,
                url: '#'
            });

            $('#rating_3').rating({
                fx: 'float',
                image: 'img/stars.png',
                loader: 'img/ajax-loader.gif',
                minimal: 0.0,
                type: 'GET',
                url: 'rating',
               width: 32,

                callback: function(responce){
                    this.vote_success.fadeOut(2000);
                    if(responce.msg) alert(responce.msg);
                }
            });

        })

    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("a.fancyimage").fancybox();
        });
    </script>


    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
// Activate carousel
            $("#myCarousel").carousel();
// Enable carousel control
            $(".left").click(function () {
                $("#myCarousel").carousel('prev');
            });
            $(".right").click(function () {
                $("#myCarousel").carousel('next');
            });

// Enable carousel indicators
            $(".slide-one").click(function () {
                $("#myCarousel").carousel(0);
            });
            $(".slide-two").click(function () {
                $("#myCarousel").carousel(1);
            });
            $(".slide-three").click(function () {
                $("#myCarousel").carousel(2);
            });
        });
    </script>


    <title>***</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/fancyimage.css">
    <link rel="stylesheet" href="../css/myEditions.css">

    <link rel="stylesheet" href="../css/jquery.fancybox.css">
    <link rel="stylesheet" href="../css/jquery.rating.css">


    <style type="text/css">
        .carousel {
            background: transparent;
            margin-top: 20px;

        }

        .carousel .item img {
            margin: 0 auto;
        }

        .bs-example {
            margin: 20px;
        }

    </style>
    <script>

    </script>
</head>


<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/">
                <p class="navbar-brand">Інформаційна система українських<br>культурних та духовних осередків</p>
            </a>
        </div>

        <div id="logindiv" class="navbar-collapse collapse">
            <sec:authorize access="!isAuthenticated()">
                <form class="navbar-form navbar-right" method="post" action="/j_spring_security_check" role="form"
                      id="loginform">

                    <div class="form-group">
                        <input type="text" placeholder="Email" class="form-control" name="j_username">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control" name="j_password">
                    </div>
                    <button id="login" type="submit" class="btn btn-success" value="Login">Увійти</button>
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#reg">
                        Реєстрація
                    </button>
                </form>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <c:url var="logoutUrl" value="/logout"/>
                <form class="navbar-form navbar-right" action="${logoutUrl}" method="post">
                    <a href="/adminpanel" class="btn btn-link" role="button">Адміністрування</a>
                    <input class="btn btn-warning" type="submit" value="Вихід"/>
                </form>
            </sec:authorize>
        </div>
    </div>
</div>


<div class="container">
    <div class="bs-example">
        <div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
            <!-- Carousel indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- Wrapper for carousel items -->
            <div class="carousel-inner">
                <div class="active item">
                    <img src="../img/slide1.jpg" alt="First Slide">

                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="../img/slide2.jpg" alt="Second Slide">

                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="../img/slide3.jpg" alt="Third Slide">

                    <div class="carousel-caption">

                    </div>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                </a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">
                </a>
            </div>


        </div>
    </div>
</div>

<div class="container" align="center">
    <div class="row"><a href="/?section=SCIENCE" data-toggle="tooltip">
        <div class="col-md-4">
            <h2>Наука</h2>

            <p>Студентські осередки, бібліотеки </p>

        </div>
    </a><a href="/?section=ART" data-toggle="tooltip">
        <div class="col-md-4">
            <h2> Мистецтво</h2>

            <p>Театри, галереї, виставки</p>

        </div>
    </a><a href="/?section=RELIGION" data-toggle="tooltip">
        <div class="col-md-4">
            <h2>Релігія</h2>

            <p>Храми, собори, церкви</p>

        </div>
    </a>

    </div>
    <hr>

    <div class="row">

        <div id="indexArt">
            <c:if test="${docs.size()>1}">
                <ul style="display: flex">
                    <c:forEach var="doc" items="${docs}">
                        <li id="${doc.docId}"
                            style="list-style: none; float: left; width: 25%; margin: 0 10px; display: flex">
                            <div class="thumbnail">
                                <a rel="group" href="/?id=${doc.docId}#imgg">

                                    <img class="img-responsive" src="data:image/jpeg;base64,${doc.images.get(0)}"/>

                                    <div class="caption" style="height: 200px; overflow: hidden">
                                        <h3>${doc.docName}</h3>

                                        <p>${doc.doc}</p>
                                    </div>


                                </a>
                                </div>
                        </li>
                    </c:forEach>

                </ul>
            </c:if>

            <c:if test="${docs.size()==1}">
                <h1>${docs.get(0).docName}</h1>

                <div> </div>
                <div>
                    <div><p>${docs.get(0).doc}</p>
                </div>

                <div>
                    <ul style="display: flex;">
                        <c:forEach var="img" items="${docs.get(0).images}">
                            <c:if test="${docs.get(0).images.size() == 1}">
                                <a name="imgg">
                                    <a class="fancyimage" rel="group" href="data:image/jpeg;base64,${img}">
                                        <img class="img-responsive" width="60%" src="data:image/jpeg;base64,${img}"/>
                                    </a>
                                </a>
                            </c:if>
                            <c:if test="${docs.get(0).images.size() >1}">

                                <li style="list-style: none; float: left; margin: 0 10px;  display: flex">
                                    <a name="imgg">
                                        <a class="fancyimage" rel="group" href="data:image/jpeg;base64,${img}">
                                            <img class="img-responsive" src="data:image/jpeg;base64,${img}"/>
                                        </a>
                                    </a>
                                </li>

                            </c:if>

                            <div>
                                <div></div>

                            </div>
                        </c:forEach>
                    </ul>
                    <div align="center" id="rating_3">

                        <input id="rate" type="hidden" class="val" value="${docs.get(0).docRating.rating}"/>
                        <input id="rateVoters" type="hidden" class="votes" value="${docs.get(0).docRating.voters}"/>
                        <input id="rateId" type="hidden" class="vote-id" value="${docs.get(0).docRating.ratingId}"/>
                    </div>

                </div>

                <div>
                    <hr>
                </div>

            </c:if>
        </div>

    </div>
    <div class="footer navbar-fixed-bottom">
        <footer class="panel-footer">
            <p>ssa.root@gmail.com</p>
        </footer>
    </div>

</div>
<!-- /container -->
<div class="modal fade" id="reg" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Реєстрація</h4>

            </div>

            <form id="registrationForm" class="form-horizontal" action="register.html" method="POST">
                <p>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Електронна пошта</label>

                    <div class="col-xs-5">
                        <LABEL ACCESSKEY=S>
                            <input type="text" class="form-control" name="email"/>
                        </LABEL>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Пароль</label>

                    <div class="col-xs-5">
                        <LABEL ACCESSKEY=S>
                            <input type="password" class="form-control" name="password"/>
                        </LABEL>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-9 col-xs-offset-3">
                        <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Надіслати</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</div>
<span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
</body>
</html>