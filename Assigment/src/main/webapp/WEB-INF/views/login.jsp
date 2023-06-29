<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <style>

        .container{

            margin-top: 100px;
            width: 450px;
            height: 370px;
            border: 1px solid gray;
            border-radius: 20px 20px 20px;

        }

        .errors, textTitle{

            color: red;

        }

    </style>

</head>
<body>
<div class="container">
     <br>
    <div class="errors">${message}</div>
    <frm:form modelAttribute="user" action="${pageContext.request.contextPath}/login" method="POST">
        <div class="mb-3">
            <label class="form-label">UserName</label>
            <frm:input path="username" class="form-control"  />
            <div class="textTitle"><frm:errors class="errors" path="username" /></div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <frm:input path="password" type="password" class="form-control" id="exampleInputPassword1" />
            <div class="textTitle"><frm:errors class="errors" path="password" /></div>
        </div>
        <div class="mb-3 form-check">
<%--            <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
            <frm:checkbox path="rememberMe" />
            <label class="form-check-label">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
<%--        <a class="col-sm-4" href="${pageContext.request.contextPath}/product/detail/${product.id}"><button class="btn btn-primary">Detail</button></a>--%>
        <a href="/add" class="btn btn-primary">Enregistrer</a>
    </frm:form>

</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>

</body>
</html>