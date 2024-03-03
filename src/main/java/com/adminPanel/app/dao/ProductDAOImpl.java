package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO
{
    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public Product insert(Product product) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            product.setExpirationDate(DateUtil.parseDate());
            session.persist(product);
            session.getTransaction().commit();
            return product;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            return (Product) session.get(Product.class , id);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Product deleteById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Product product = (Product) session.get(Product.class , id);
            session.delete(product);
            session.getTransaction().commit();
            return product;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(int id, Product newProduct) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Product product =  (Product) session.get(Product.class , id);
            product.setName(newProduct.getName());
            session.persist(product);
            session.getTransaction().commit();

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Product");
            return (List<Product>) query.list();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
