package com.codegym.repository;

import com.codegym.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findALl() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer as c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        Customer customer= em.find(Customer.class,id);
        return  customer;
    }

    @Override
    public void save(Customer model) {
        if(model.getId() != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            em.remove(customer);
        }
    }
}
