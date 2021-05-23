package com.example.demoFood.controller;

import com.example.demoFood.entity.Food;
import com.example.demoFood.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EditFoodServlet extends HttpServlet {
    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/food/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // khắc phục lỗi utf8 ở view.
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodService.getById(id);
        // validate
        if(!food.isValid()){
            HashMap<String, ArrayList<String>> errors = food.getErrors();
            req.setAttribute("errors", errors);
            req.setAttribute("food", food);
            req.getRequestDispatcher("/food/update.jsp").forward(req, resp);
            return;
        }

        food.setName(req.getParameter("name"));
        food.setCategory(Integer.parseInt(req.getParameter("category")));
        food.setDescripts(req.getParameter("descripts"));
        food.setAvatar(req.getParameter("avatar"));
        food.setPrice(Double.parseDouble(req.getParameter("price")));
        food.setStatus(Integer.parseInt(req.getParameter("status")));

        foodService.edit(id, food);
        resp.sendRedirect("/food/list");
    }
}
