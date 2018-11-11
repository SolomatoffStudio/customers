package com.solomatoff.mvc.controller;

import com.solomatoff.mvc.model.entities.Customer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrudCustomerServlet extends HttpServlet {
    // Переменная для объекта Controller
    private static final Controller CONTROLLER = Controller.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("    CrudCustomerServlet.doGet.  %s?%s%n", request.getRequestURI(), request.getQueryString());
        response.setContentType("text/html;charset=utf-8");
        String pAction = request.getParameter("action");
        String pId = request.getParameter("id");

        Customer customer = new Customer();
        // Display a page to create or view, edit, delete user.
        if (pAction.equals("Create Customer")) {
            request.setAttribute("customer", customer);
            CONTROLLER.getPresentation().showCreateCustomer(request, response);
        } else {
            long longId = 0L;
            if (!pId.equals("")) {
                longId = Long.parseLong(pId);
            }
            // Заполним остальные поля customer
            customer = CONTROLLER.getLogic().findByIdCustomer(longId);
            request.setAttribute("customer", customer);
            CONTROLLER.getPresentation().showRudCustomer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("    CrudCustomerServlet.doPost.  %s?%s %n", request.getRequestURI(), request.getQueryString());
        response.setContentType("text/html;charset=utf-8");
        String pAction = request.getParameter("action");
        String pId = request.getParameter("id");

        String pName = request.getParameter("name");
        String pSurname = request.getParameter("surname");
        String pEmail = request.getParameter("email");
        long longId;
        Customer customer;
        if (!pId.equals("")) {
            // ToDo
            longId = Long.parseLong(pId);
            customer = new Customer(longId, pName, pSurname, pEmail);
        } else {
            customer = new Customer(null, pName, pSurname, pEmail);
        }
        System.out.printf("    CrudCustomerServlet.doPost.  customer = %s %n", customer);
        switch (pAction) {
            case "Create Customer":
                CONTROLLER.getLogic().addCustomer(customer);
                break;
            case "Update Customer":
                CONTROLLER.getLogic().updateCustomer(customer);
                break;
            case "Delete Customer":
                CONTROLLER.getLogic().deleteCustomer(customer);
                break;
            default:
                CONTROLLER.getLogic().findByIdCustomer(customer.getId());
        }
        // Переходим на страницу списка пользователей
        try {
            response.sendRedirect(String.format("%s/listcustomers", request.getContextPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
