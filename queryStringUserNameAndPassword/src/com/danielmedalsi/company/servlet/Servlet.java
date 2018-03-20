package com.danielmedalsi.company.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "Servlet",urlPatterns = "/myServlet",description = "")
public class Servlet extends javax.servlet.http.HttpServlet {

    private int counter = 0;
    Map<String, String> qs = new HashMap<>();




    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("count = " + counter + "\n");
        String queryString = request.getQueryString();
        
    }
}
