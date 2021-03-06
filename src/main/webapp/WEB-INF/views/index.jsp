<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 11.03.2022
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>farm_render_testTask</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>farm_render - список тасок.</h4>
    </div>
    <div>
        Login as : ${user.username} | <a href="<c:url value='/logout'/>">Выйти</a>
    </div>

    <div class="row">
        <table class="table">
            <thead>
            <tr> <a href="<c:url value='/task-create'/>">Add another task</a></tr>
            <tr>
                <th scope="col">#</th>
                <th scope="col">TaskName</th>
                <th scope="col">Description</th>
                <th scope="col">Created</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="task">
                <tr>
                    <td><c:out value="${task.id}"/></td>
                    <td><c:out value="${task.name}"/></td>
                    <td><c:out value="${task.description}"/></td>
                    <td><fmt:formatDate value="${task.created.time}" type="date" dateStyle="short" /></td>
                    <td><c:out value="${task.status}"/></td>
                    <td><a href="<c:out value='/task-delete/?id=${task.id}'/>">Delete task</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>