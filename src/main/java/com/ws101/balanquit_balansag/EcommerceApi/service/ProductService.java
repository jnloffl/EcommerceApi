package com.ws101.balanquit_balansag.EcommerceApi.service;

import com.ws101.balanquit_balansag.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // Constructor - adds 10 sample products
    public ProductService() {
        products.add(new Product(nextId++, "Smart Watch Pro", "Track fitness, heart rate", 3999.00, "Wearables", 10, "smartwatch.jpg"));
        products.add(new Product(nextId++, "Wireless Headphones", "Noise cancellation", 2499.00, "Audio", 15, "headphones.jpg"));
        products.add(new Product(nextId++, "Bluetooth Speaker", "Portable, deep bass", 1899.00, "Audio", 20, "speaker.jpg"));
        products.add(new Product(nextId++, "Mechanical Keyboard", "RGB backlit", 2999.00, "Accessories", 8, "keyboard.jpg"));
        products.add(new Product(nextId++, "Gaming Mouse", "16000 DPI", 1899.00, "Accessories", 12, "mouse.jpg"));
        products.add(new Product(nextId++, "Portable Monitor", "15-inch USB-C", 5999.00, "Electronics", 5, "monitor.jpg"));
        products.add(new Product(nextId++, "USB-C Hub", "7-in-1 adapter", 1299.00, "Electronics", 25, "usbhub.jpg"));
        products.add(new Product(nextId++, "Phone Stand", "Adjustable aluminum", 399.00, "Accessories", 50, "stand.jpg"));
        products.add(new Product(nextId++, "Power Bank", "20000mAh", 1499.00, "Electronics", 18, "powerbank.jpg"));
        products.add(new Product(nextId++, "Fitness Tracker", "Heart rate monitor", 2299.00, "Wearables", 7, "fitness.jpg"));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with ID " + id + " not found"));
    }

    // Create new product
    public Product createProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        updatedProduct.setId(id);
        int index = products.indexOf(existing);
        products.set(index, updatedProduct);
        return updatedProduct;
    }

    // Delete product
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        products.remove(product);
    }

    // Filter products
    public List<Product> filterProducts(String filterType, String filterValue) {
        return products.stream()
                .filter(product -> {
                    switch (filterType.toLowerCase()) {
                        case "category":
                            return product.getCategory().toLowerCase().contains(filterValue.toLowerCase());
                        case "price":
                            double price = Double.parseDouble(filterValue);
                            return product.getPrice() <= price;
                        case "name":
                            return product.getName().toLowerCase().contains(filterValue.toLowerCase());
                        default:
                            return false;
                    }
                })
                .toList();
    }
}