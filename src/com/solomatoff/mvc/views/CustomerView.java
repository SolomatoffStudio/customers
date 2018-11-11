package com.solomatoff.mvc.views;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerView implements ViewLyaer {

    public void showListCustomers(HttpServletRequest request, HttpServletResponse response) {
        show(request, response, "/WEB-INF/views/listCustomers.jsp");
    }

    @Override
    public void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        show(request, response, "/WEB-INF/views/createCustomer.jsp");
    }

    @Override
    public void showRudCustomer(HttpServletRequest request, HttpServletResponse response) {
        show(request, response, "/WEB-INF/views/rudCustomer.jsp");
    }

    private void show(HttpServletRequest request, HttpServletResponse response, String path) {
        System.out.printf("CustomerView.show. %s%s %n", request.getRequestURI(), request.getQueryString());
        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
