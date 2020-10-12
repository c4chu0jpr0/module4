package com.codegym.service.customers;

import com.codegym.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerService implements ICustomerService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Iterable<Customer> findAll(){
        EntityManager entityManager =sessionFactory.createEntityManager();
        String queryStr = "select c from Customer as c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr,Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        EntityManager entityManager =sessionFactory.createEntityManager();
        String queryStr="SELECT c from  Customer as c where c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Customer update(Customer model) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Customer save(Customer model) {
        Session session = null;
        Transaction transaction = null;
        try{
            session= sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
            return model;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void remove(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try{
            session= sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(findById(id));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}
