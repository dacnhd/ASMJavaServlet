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

public class DeleteFoodServlet extends HttpServlet {
    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        foodService.delete(id);
        req.getRequestDispatcher("/food/delete.jsp").forward(req, resp);
    }
}
