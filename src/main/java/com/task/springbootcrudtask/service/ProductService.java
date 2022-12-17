package com.task.springbootcrudtask.service;

import com.task.springbootcrudtask.model.Category;
import com.task.springbootcrudtask.model.Product;
import com.task.springbootcrudtask.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public Product addProduct (Product product){
        return productRepository.save(product);
    }

    public String deleteProductById(int productId){
            productRepository.deleteById(productId);
            return "Product deleted : id= " + productId;
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product update(int productId, Product product){
        Product updatedProduct = productRepository.findById(productId).get();
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setName(product.getName());
        updatedProduct.setColor(product.getColor());
        updatedProduct.setSize(product.getSize());
        updatedProduct.setPrice(product.getPrice());
        return productRepository.save(updatedProduct);
    }

    public Product getProductById (int productId){
        return productRepository.findById(productId).get();
    }
}
