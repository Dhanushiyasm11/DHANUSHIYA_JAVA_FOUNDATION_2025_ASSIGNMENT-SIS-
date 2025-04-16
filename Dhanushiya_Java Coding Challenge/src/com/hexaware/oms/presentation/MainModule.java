package com.hexaware.oms.presentation;

import com.hexaware.oms.entity.Product;
import com.hexaware.oms.entity.User;
import com.hexaware.oms.service.IOrderService;
import com.hexaware.oms.service.OrderServiceImpl;
import com.hexaware.oms.exception.OrderNotFoundException;
import com.hexaware.oms.exception.UserNotFoundException;

import java.util.Arrays; 
import java.util.List;
import java.util.Scanner;

public class MainModule {

    static Scanner sc = new Scanner(System.in);
    static IOrderService service = new OrderServiceImpl();

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            System.out.println("Order Management System Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Create Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Get All Products");
            System.out.println("6. Get Orders by User");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    createUser();
                    break;

                case 2:
                    createProduct();
                    break;

                case 3:
                    createOrder();
                    break;

                case 4:
                    cancelOrder();
                    break;

                case 5:
                    getAllProducts();
                    break;

                case 6:
                    getOrdersByUser();
                    break;

                case 7:
                    flag = false;
                    System.out.println("Thank you for using the Order Management System!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose a valid option.");
            }
        }
    }

    private static void createUser() {
        System.out.println("Enter user details:");
        System.out.print("User ID: ");
        
        int userId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Username: ");
       
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
       
        System.out.print("Role (Admin/User): ");
        String role = sc.nextLine();

        User user = new User(userId, username, password, role);
        service.createUser(user);
        System.out.println("User created successfully!");
    }

    private static void createProduct() {
        System.out.println("Enter product details:");
        System.out.print("Product ID: ");
        int productId = sc.nextInt();
       
        sc.nextLine(); 
        System.out.print("Product Name: ");
        String productName = sc.nextLine();
        System.out.print("Description: ");
       
        
        String description = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity in Stock: ");
       
        int quantityInStock = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Product Type (Electronics/Clothing): ");
        String type = sc.nextLine();

        Product product = new Product(productId, productName, description, price, quantityInStock, type);
        service.createProduct(new User(1, "Admin", "adminpass", "Admin"), product); // Admin role can create products
        System.out.println("Product created successfully!");
    }

    private static void createOrder() {
        System.out.println("Enter user details:");
       
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter product IDs for the order:");
       
        List<Product> products = service.getAllProducts(); // Fetch all products to order from
        for (Product product : products) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName());
        }

        System.out.print("Enter product ID to add to the order: ");
        int productId = sc.nextInt();
        Product product = new Product(productId, "Sample Product", "Description", 100.0, 10, "Electronics"); // Example product

        try {
            
            service.createOrder(new User(userId, "testUser", "password", "User"), Arrays.asList(product)); // Create order for user
            System.out.println("Order created successfully!");
        } catch (UserNotFoundException e) {
            
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cancelOrder() {
        System.out.println("Enter user ID and order ID to cancel the order:");
        System.out.print("User ID: ");
      
        int userId = sc.nextInt();
        System.out.print("Order ID: ");
        int orderId = sc.nextInt();

        try {
            service.cancelOrder(userId, orderId);
            System.out.println("Order canceled successfully!");
        } catch (UserNotFoundException | OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAllProducts() {
        List<Product> products = service.getAllProducts();
     
        System.out.println("All products in the system:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " - " + product.getPrice());
        }
    }

    private static void getOrdersByUser() {
        System.out.println("Enter user ID to get their orders:");
     
        System.out.print("User ID: ");
        int userId = sc.nextInt();

        try {
            List<Product> products = service.getOrderByUser(new User(userId, "testUser", "password", "User"));
            System.out.println("Orders for User " + userId + ":");
            for (Product product : products) {
                System.out.println(product.getProductName() + " - " + product.getPrice());
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
