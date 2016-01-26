<%--
  Created by IntelliJ IDEA.
  User: admssa
  Date: 31.05.2015
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="js/jquery-2.1.3.min.js"></script>

    <title>Financial analitics</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>
    <script src="js/financial.js"></script>


</head>

</nav><div class="container">
    <h2>Financial Analiticss</h2>
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#home">Главная</a></li>
        <li><a data-toggle="tab" href="#menu0">Вводные данные</a></li>
        <li><a data-toggle="tab" href="#menu1">Линейный тренд</a></li>
        <li><a data-toggle="tab" href="#menu2">Тенденция</a></li>
        <li><a data-toggle="tab" href="#menu3">О приложении</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane fade in active">
            <h3>Главная</h3>
            <p>Данное приложение разработано студентом группы 402 Шаповаленко С.А.</p>
            <p><img class="img-thumbnail" alt="Cinque Terre" src="img/business_infograph2.jpg"></p>

        </div>
        <div id="menu0" class="tab-pane fade">
            <h3>Вводные данные</h3>
            <div class="table-right">
                <div class="panel panel-default">
                    <div class="panel-heading">Продажи в разрезе времени</div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <tr>
                                <td>ID</td>
                                <td>Date</td>
                                <td>Sales</td>
                            </tr>
                            <c:forEach var="sList" items="${salesList}">
                                <tr>
                                    <td><c:out value="${sList.id}"/></td>
                                    <td><c:out value="${sList.onDate}"/></td>
                                    <td><c:out value="${sList.summ}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div id="menu1" class="tab-pane fade">
            <div class="container">
                <h2>Линейный тренд</h2>
                   <button onclick=linear() type="button" id="btn-liner" class="btn btn-default">Рассчитать</button>
                <br>

                <div class="panel panel-default">
                <div class="panel-heading"></div>
                <div class="panel-body">
        <p id="arr"></p>
                </div>
           </div>
            </div>
        </div>

        <div id="menu2" class="tab-pane fade">
            <div class="container">
                <h2>Тенденция</h2>
                <p>Укажите срок, на который необходимо составить прогноз:</p>
                <form role="form">
                    <div class="form-group">
                        <label for="sel2">Месяцы:</label>
                        <select class="form-control" id="sel2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                        </select>
                        <br>
                        <button onclick=trailMessage() type="button" id="btn-trend" class="btn btn-default">Рассчитать</button>
                        </div>
                    <div>
                        <p id="mess"></p>
                        </div>

                </form>
            </div>
        </div>
        <div id="menu3" class="tab-pane fade">
            <h3>О приложении</h3>
            <p>Данное приложение разработано с использованием JAVA, JS, Oraclre.</br>
                Используя принципы: MVC, ORM.
                Инструменты: Spring, Hibernate, Servlets, JSP, JSTL, JQuerry, Ajax, Bootstrap, Log4j
            </p>
        </div>
    </div>
</div>

</body>
</html>
