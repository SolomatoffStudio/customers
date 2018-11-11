package com.solomatoff.mvc.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewLyaer {
    void showListCustomers(HttpServletRequest request, HttpServletResponse response);
    void showCreateCustomer(HttpServletRequest request, HttpServletResponse response);
    void showRudCustomer(HttpServletRequest request, HttpServletResponse response);
}
