package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.Product;
public interface ProductService {
    
    public abstract void createProduct(Product product);
    public abstract void updateProduct(Long id, Product product);
    public abstract void deleteProduct(Long id);
    public abstract Collection<Product> getProducts();
    public abstract Product getProduct(Long id);
}
