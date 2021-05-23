package com.example.demoFood.controller;

import com.example.demoFood.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListFoodServlet extends HttpServlet {

    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listFood", foodService.getList());
        req.getRequestDispatcher("/food/list.jsp").forward(req, resp);
    }
}
