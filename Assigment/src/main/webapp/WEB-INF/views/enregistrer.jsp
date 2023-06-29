<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Enregistrer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>

<div class="container">
    <br>
    <div class="errors">${message}</div>
    <frm:form
            modelAttribute="user"
            action="${pageContext.request.contextPath}/add"
            method="POST">
        <div class="mb-3">
            <label class="form-label">Name</label>
            <frm:input path="name" class="form-control"  />
            <div class="textTitle"><frm:errors class="errors" path="name" /></div>
        </div>
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
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
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