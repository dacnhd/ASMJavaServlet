<%@ page import="com.example.demoFood.entity.Food" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuudac
  Date: 5/21/2021
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Food> listFood = (ArrayList<Food>) request.getAttribute("listFood");
%>
<html>
<head>
    <title>List Food</title>
    <style>
        .a-href{
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>List Food</h1>
<ul>
    <% if(listFood != null && listFood.size() > 0){
        for(int i = 0; i < listFood.size(); i++){
    %>
    <li>
        <%= listFood.get(i).getName()%>
        <%= listFood.get(i).getStatus()%>
        <%= listFood.get(i).getCategory()%>
        <%= listFood.get(i).getPrice()%>
        <button><a href="/food/update?id=<%= listFood.get(i).getId()%>" class="a-href">Update</a></button>
        <button><a href="/food/delete?id=<%= listFood.get(i).getId()%>" class="a-href">Delete</a></button>
    </li>
    <%
            }
        }
    %>
</ul>
<%----%>
</body>
</html>
