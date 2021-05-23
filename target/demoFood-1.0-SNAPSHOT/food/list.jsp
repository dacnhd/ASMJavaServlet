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
<ul class="start">
    <%                //Button Previous
        int first = 0, last = 5, pages = 1;
        int total = listFood.size();
        if (total <= 5) {
            first = 0;
            last = total;
        } else {
            first = (pages - 1) * 5;
            last = 5;
        }

        int back = 0;
        if (pages == 0 || pages == 1) {
            back = 1;//Luon la page 1
        } else {
            back = pages - 1;//Neu pages tu 2 tro len thi back tru 1
        }
    %>
    <li >
        <input name="total" value="<%= total%>">
        <a href="/food/list?pages=<%=back%>"><i></i></a></li>
    <%
        //Button Number pages
        int loop = 0, num = 0;
        if ((total / 5) % 2 == 0) {
            num = total / 5;
        } else {
            num = (total + 1) / 5;
        }
        //Nếu total lẻ thêm 1
        if (total % 2 != 0) {
            loop = (total / 5) + 1;

        } else {
            //Nếu total chẵn nhỏ hơn fullpage và # fullPage thì thêm 1
            if (total < (num * 5) + 5 && total != num * 5) {
                loop = (total / 5) + 1;
            } else {
                //Nếu bằng fullPage thì không thêm
                loop = (total / 5);
            }
        }
        //Lap so pages
        for (int i = 1; i <= loop; i++) {%>
    <% if (pages == i) {%>

    <li><span><a href="/food/list?pages=<%=i%>"><%=i%></a></span></li>
    <%} else {%>
    <li class="arrow"><a href="/food/list?pages=<%=i%>"><%=i%></a> </li>

    <%}
    }%>
    <%
        //Button Next
        int next = 0;
        //Nếu total lẻ
        if (total % 2 != 0) {
            if (pages == (total / 5) + 1) {
                next = pages;//Khong next
            } else {
                next = pages + 1;//Co next
            }
        } else {
            //Nếu total chẵn nhỏ hơn fullpage
            //Và không fullPage thì thêm 1
            if (total < (num * 5) + 5 && total != num * 5) {
                if (pages == (total / 5) + 1) {
                    next = pages;//Khong next
                } else {
                    next = pages + 1;//Co next
                }
            } else {
                //Nếu fullPage đến trang cuối dừng
                //Chưa tới trang cuối thì được next
                if (pages == (total / 5)) {
                    next = pages;//Khong next
                } else {
                    next = pages + 1;//Co next
                }
            }
        }
    %>
    <li ><a href="/food/list?pages=<%=next%>"><i class="next"></i></a></li>
</ul>
</div>
</body>
</html>
