package com.virtualstore.virtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.virtualstore.virtualstore.entities.Product;
import com.virtualstore.virtualstore.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setBrand(product.getBrand());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setUnitPrice(product.getUnitPrice());
        productToUpdate.setSize(product.getSize());
        productToUpdate.setImage(product.getImage());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setSubCategory(product.getSubCategory());
        productToUpdate.setOrders(product.getOrders());
        productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        if(productRepository.findById(id) == null){
            return null;
        }else{
            return productRepository.findById(id).get();
        }
    }
    
}
