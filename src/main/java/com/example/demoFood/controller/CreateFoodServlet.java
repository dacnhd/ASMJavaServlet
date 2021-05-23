package com.example.demoFood.controller;

import com.example.demoFood.entity.Food;
import com.example.demoFood.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateFoodServlet extends HttpServlet {

    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/food/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        // upload file
//        Part filePart = req.getPart("file");
//        String fileName = filePart.getSubmittedFileName();
//        for (Part part : req.getParts()) {
//            part.write("D:\\upload\\" + fileName);
//        }

        // khắc phục lỗi utf8 ở view.
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int category = Integer.parseInt(req.getParameter("category"));
        String descripts = req.getParameter("descripts");

        String avatar = req.getParameter("descripts");
        double price = Double.parseDouble(req.getParameter("price"));
        int status = Integer.parseInt(req.getParameter("status"));
        Food food = new Food(name, category, descripts, avatar, price, status);
        // validate
        if(!food.isValid()){
            HashMap<String, ArrayList<String>> errors = food.getErrors();
            req.setAttribute("errors", errors);
            req.setAttribute("food", food);
            req.getRequestDispatcher("/food/create.jsp").forward(req, resp);
            return;
        }
        foodService.create(food);
        resp.sendRedirect("/food/list");
    }
}
