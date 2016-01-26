<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <script src="../js/jquery-2.1.3.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/myEditions.css">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/inputfile.js"></script>


    <script src="../js/uploadFunction.js"></script>
    <title></title>
</head>
<body>
<nav class="navbar navbar-inverse">

    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand">Панель адміністрування</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a data-toggle="tab" href="#about">Про додаток</a></li>
                <li><a data-toggle="tab" href="#articles">Управління статтями</a></li>
                <li><a data-toggle="tab" href="#users">Управління користівачами</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <li><a href="/#">Вихід</a></li>
            </form>
        </div>
    </div>
</nav>

<div class="container">
    <div class="tab-content">
        <div id="about" class="tab-pane fade in active">
            <h2>Панель адміністрування</h2>

            <p>Інформаційної системи українських
                культурних та духовних осередків</p>

        </div>

        <div id="articles" class="tab-pane fade">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#addarticle">Додати статтю</a></li>
                <li><a name="del" data-toggle="tab" href="#removearticle">Видалити статтю</a></li>
            </ul>

            <div class="tab-content">
                <div id="addarticle" class="tab-pane fade in active">
                    <h3>Додати статтю</h3>

                    <form role="form"action="/addart.html" method="POST"  enctype="multipart/form-data"  name="form-addart" id="form-addart">
                        <div class="form-group">
                            <select id="sectionDrop" name="sectionDrop" class="btn btn-default dropdown-toggle">
                                <option value="SCIENCE">Наука</option>
                                <option value="ART">Мистецтво</option>
                                <option value="RELIGION">Релігія</option>
                            </select>

                            </div>
                        <div class="form-group">
                            <label for="docName">Назва статті</label>
                            <input type="text" class="form-control" id="docName" name="docName">
                        </div>
                        <div class="form-group">
                            <label for="doc">Текст статті</label>
                            <textarea class="form-control" rows="5" id="doc" name="doc"></textarea>
                        </div>

                        <div class="input-group">
                                <span class="input-group-btn">
                                    <span class="btn btn-primary btn-file">Обрати&hellip; <input type="file"  multiple id="fileupload" class="file-loading" accept="image/*" name="filesList">
                                    </span>
                                </span>
                            <input type="text" class="form-control" readonly>
                        </div>
                                <span class="help-block">
                                    Додати один або декілька файлів
                                </span>

            <button type="submit" class="btn btn-default">Додати</button>
                    </form>

                </div>
                <div id="removearticle" class="tab-pane fade">
                    <h3>Видалити статтю</h3>

                    <p>
                    <table class="table table-striped">
                    <th>ID</th><th>Назва статті</th><th>Рейтинг</th><th></th>
                    <c:forEach var="doc" items="${docsfd}">
                        <tr><td>${doc.docId}</td><td>${doc.docName}</td><td>${doc.docRating.rating}</td><td><a href="/removeart?delete=${doc.docId}&ratingId=${doc.docRating.ratingId}" class="btn btn-primary">Видалити</a></td></tr>
                    </c:forEach>
                </table>
                    </p>
                </div>
            </div>
        </div>

        <div id="users" class="tab-pane fade">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#adduser">Додати користувача</a></li>
                <li><a data-toggle="tab" href="#removeuser">Видалити користувача</a></li>
                <li><a data-toggle="tab" href="#updateuser">Корегувати користувача</a></li>
            </ul>

            <div class="tab-content">
                <div id="adduser" class="tab-pane fade in active">
                    <h3>Додати користувача</h3>

                    <p>Some content.</p>
                </div>
                <div id="removeuser" class="tab-pane fade">
                    <h3>Видалити користувача</h3>

                    <p>Some content in menu 1.</p>
                </div>
                <div id="updateuser" class="tab-pane fade">
                    <h3>Корегувати користувача</h3>

                    <p>Some content in menu 1.</p>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
