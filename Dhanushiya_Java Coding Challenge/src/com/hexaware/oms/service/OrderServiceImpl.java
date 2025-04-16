package com.hexaware.oms.service;

import com.hexaware.oms.dao.IOrderManagementRepository;
import com.hexaware.oms.dao.OrderProcessor;
import com.hexaware.oms.entity.Product;
import com.hexaware.oms.entity.User;
import com.hexaware.oms.exception.OrderNotFoundException;
import com.hexaware.oms.exception.UserNotFoundException;

import java.util.List;

public class OrderServiceImpl implements IOrderService {

    private IOrderManagementRepository repository;

    public OrderServiceImpl() {
        this.repository = new OrderProcessor(); 
    }

    @Override
    public void createUser(User user) {
        repository.createUser(user);
    }

    @Override
    public void createProduct(User user, Product product) {
        repository.createProduct(user, product);
    }

    @Override
    public void createOrder(User user, List<Product> products) throws UserNotFoundException {
        repository.createOrder(user, products);
    }

    @Override
    public void cancelOrder(int userId, int orderId) throws UserNotFoundException, OrderNotFoundException {
        repository.cancelOrder(userId, orderId);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    @Override
    public List<Product> getOrderByUser(User user) throws UserNotFoundException {
        return repository.getOrderByUser(user);
    }
}
