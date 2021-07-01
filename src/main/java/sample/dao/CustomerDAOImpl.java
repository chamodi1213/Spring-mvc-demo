package sample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sample.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

//    inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
//        get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        create query
        Query<Customer> theQuery = currentSession.createQuery(
                "from Customer", Customer.class);

//        execute query and get result
        List<Customer> customers = theQuery.getResultList();

//        return results
        return customers;
    }
}
