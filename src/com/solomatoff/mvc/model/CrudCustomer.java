package com.solomatoff.mvc.model;


import com.solomatoff.mvc.model.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CrudCustomer {
    public EntityManager em = Persistence.createEntityManagerFactory("Customer").createEntityManager();

    public Customer addCustomer(Customer customer) {
        System.out.printf("    CrudCustomer. customer.getId = %s %n", customer.getId());
        em.getTransaction().begin();
        Customer customerFromDB = em.merge(customer);
        em.getTransaction().commit();
        return customerFromDB;
    }

    public void deleteCustomer(long id) {
        em.getTransaction().begin();
        em.remove(getCustomer(id));
        em.getTransaction().commit();
    }

    public Customer getCustomer(long id){
        return em.find(Customer.class, id);
    }

    public void updateCustomer(Customer customer){
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    public List<Customer> findAll(){
        TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.findAll", Customer.class);
        return namedQuery.getResultList();
    }

}
