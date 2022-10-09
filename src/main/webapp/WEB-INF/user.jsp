
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header-icons.html"%>
<html>
<head>
    <title>User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
          crossorigin="anonymous">

</head>
<body>
<div class="container"> </div>
<form class="form-horizontal" action="user? id=${requestScope.user.id}" method="post"
      enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <legend align="center">User Form</legend>

        <!-- Avatar Input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="userImage">Avatar</label>
            <div class="col-md-4">
                <input id="userImage" name="image" type="file" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="userLogin">Login</label>
            <div class="col-md-4">
                <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md" required=""
                value="${requestScope.user.login}">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="userPassword">Password</label>
            <div class="col-md-4">
                <input id="userPassword" name="password" type="password" placeholder="" class="form-control input-md"
                       required="" value="${requestScope.user.password}">
            </div>
        </div>


        <!-- Button Drop Down -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttondropdown">Role</label>
            <div class="col-md-4">
                <div class="input-group">
                    <input id="buttondropdown" name="buttondropdown" class="form-control" placeholder="select Role" type="text">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            Role
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#">USER</a></li>
                            <li><a href="#">GUEST</a></li>
                            <li><a href="#">ADMIN</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" name="${requestScope.user.id>0?"update":"create"}"
                        class="btn btn-success">${requestScope.user.id>0?"Update":"Create"}</button>
            </div>
        </div>


        <!-- Button -->
        <c:if test="${requestScope.user.id!=0}">
        <div class="form-group">
            <label class="col-md-4 control-label" for="userDelete"></label>
            <div class="col-md-4">
                <button id="userDelete" name="delete" class="btn btn-danger">Delete</button>
            </div>
        </div>
        </c:if>
    </fieldset>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
<%@include file="/footer.html"%>
</body>
</html>
