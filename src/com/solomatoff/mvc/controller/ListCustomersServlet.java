package com.solomatoff.mvc.controller;

import com.solomatoff.mvc.model.CrudCustomer;
import com.solomatoff.mvc.model.entities.Customer;
import com.solomatoff.mvc.views.CustomerView;
import com.solomatoff.mvc.views.ViewLyaer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListCustomersServlet extends HttpServlet {
    // Переменная для объекта Controller
    private static final Controller CONTROLLER = Controller.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.printf("    ListCustomersServlet.doGet.  %s?%s%n", request.getRequestURI(), request.getQueryString());

        ViewLyaer viewLyaer = new CustomerView();
        CONTROLLER.setPresentation(viewLyaer);

        CrudCustomer modelStore = new CrudCustomer();
        CONTROLLER.getLogic().setPersistent(modelStore);

        List<Customer> customers = CONTROLLER.getLogic().findAllCustomer();
        request.setAttribute("customers", customers);
        CONTROLLER.getPresentation().showListCustomers(request, response);
    }
}
