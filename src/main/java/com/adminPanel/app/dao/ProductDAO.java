package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductDAO
{
    Product insert(Product product);
    Product findById(int id);
    Product deleteById(int id);
    Product update(int id , Product product);
    List<Product> getAllProducts();
}
