package com.hexaware.oms.dao;

import com.hexaware.oms.entity.Product;
import com.hexaware.oms.entity.User;
import com.hexaware.oms.exception.OrderNotFoundException;
import com.hexaware.oms.exception.UserNotFoundException;

import java.util.List;

public interface IOrderManagementRepository {

    
    void createOrder(User user, List<Product> products) throws UserNotFoundException;
 
    void cancelOrder(int userId, int orderId) throws UserNotFoundException, OrderNotFoundException;

   
    void createProduct(User user, Product product);

  
    void createUser(User user);

    
    List<Product> getAllProducts();

  
    List<Product> getOrderByUser(User user) throws UserNotFoundException;
}
