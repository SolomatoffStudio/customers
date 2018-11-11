package com.solomatoff.mvc.model;

import com.solomatoff.mvc.model.entities.Customer;

import java.util.List;

/**
 * The class is a layer of logic, is part of the model mvc
 */
public class ModelLogic {
    // Field for persistent layer object
    private CrudCustomer persistent = new CrudCustomer();
    
    public CrudCustomer getPersistent() {
        return persistent;
    }
    public void setPersistent(CrudCustomer persistent) {
        this.persistent = persistent;
    }

    public Customer addCustomer(Customer customer) {
        return persistent.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        persistent.updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer) {
        persistent.deleteCustomer(customer.getId());
    }

    public Customer findByIdCustomer(long id) {
        return persistent.getCustomer(id);
    }

    public List<Customer> findAllCustomer() {
        return persistent.findAll();
    }
}
