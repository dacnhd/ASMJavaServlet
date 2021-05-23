<%@ page import="com.example.demoFood.entity.Food" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.demoFood.helper.ValidateConstant" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuudac
  Date: 5/23/2021
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Food food = (Food) request.getAttribute("food");
  HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
  if (food == null){
    food = new Food();
  }
  if (errors == null){
    errors = new HashMap<String, ArrayList<String>>();
  }
%>
<html>
<head>
  <title>Update food</title>
  <style>
    .error-msg{
      color: red;
    }
  </style>
</head>
<body>
<h1>Update form</h1>
<form action="/food/update" method="post">
  <div>
    Id <input type="text" name="id" value="${param.id}" readonly>
  </div>
  <div>
    Name <input type="text" name="name" value="<%= food.getName()%>">
    <span class="error-msg">
                <ul>
                    <%
                      if (errors.containsKey(ValidateConstant.FOOD_NAME_FIELDNAME)){
                        ArrayList<String> nameErrors = errors.get(ValidateConstant.FOOD_NAME_FIELDNAME);
                        for (String msg: nameErrors) {
                    %>
                            <li><%= msg%></li>
                    <%
                        }
                      }
                    %>
                </ul>
            </span>
  </div>
  <div>
    Category
    <select name="category" value="<%= food.getCategory()%>">
      <option value="1">Mon Nuong</option>
      <option value="2">Mon Luoc</option>
      <option value="3">Mon Chay</option>
      <option value="4">Do uong</option>
    </select>
  </div>
  <div>
    Descripts <input type="text" name="descripts" value="<%= food.getDescripts()%>">
  </div>
  <div>
    Avatar <input type="text" name="avatar" value="<%= food.getAvatar()%>">
  </div>
  <div>
    Price <input type="text" name="price" value="<%= food.getPrice()%>">
    <span class="error-msg">
                <ul>
                    <%
                      if (errors.containsKey(ValidateConstant.FOOD_PRICE_FIELDNAME)){
                        ArrayList<String> priceErrors = errors.get(ValidateConstant.FOOD_PRICE_FIELDNAME);
                        for (String msg: priceErrors) {
                    %>
                            <li><%= msg%></li>
                    <%
                        }
                      }
                    %>
                </ul>
            </span>
  </div>
  <div>
    Status
    <select name="status" value="<%= food.getStatus()%>">
      <option value="1">Dang ban</option>
      <option value="0">Dung ban</option>
      <option value="-1">Da xoa</option>
    </select>
  </div>
  <div>
    <input type="submit" value="Update">
    <input type="reset" value="Reset">
  </div>
</form>

</body>
</html>
