<%--
  Created by IntelliJ IDEA.
  User: nguyenhuudac
  Date: 5/23/2021
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    int id = Integer.parseInt(request.getParameter("id"));--%>
<%--    request.setAttribute("id", id);--%>
<%--%>--%>
<html>
<head>
    <title>Delete Food</title>
    <style>
        .a-href{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Delete Food success</h1>
    <form action="/food/delete" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div>
            <button><a href="/food/list" class="a-href">List Food</a></button>
        </div>
    </form>
</body>
</html>
