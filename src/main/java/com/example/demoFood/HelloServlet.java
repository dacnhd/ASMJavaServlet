package com.example.demoFood;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");

        String fileName = filePart.getSubmittedFileName();
        for (Part part : req.getParts()) {
            part.write("D:\\upload\\" + fileName);
        }
        resp.getWriter().print("The file uploaded sucessfully. " + fileName);
    }

//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
}