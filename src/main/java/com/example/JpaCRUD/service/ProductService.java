/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JpaCRUD.service;

import com.example.JpaCRUD.entity.Product;
import com.example.JpaCRUD.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Azim Isroilov
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Product saveProduct(Product product){
   
       return productRepository.save(product);
            
            }
    
    public List<Product> saveProducts(List<Product> products){
        
        return productRepository.saveAll(products);
    }
    
    public List<Product> getProducts(){
    return productRepository.findAll();
    }
    
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    
    public Product getProductByName(String name){
    
    return productRepository.findByName(name);
    }
    
     public String deleteProduct(int id){
    
    productRepository.deleteById(id);
        return "product removed !! "+id;
     }
     
     public Product updateProduct(Product product){
         Product existingProduct = productRepository.findById(product.getId()).orElse(null);
         existingProduct.setName(product.getName());
         existingProduct.setQuantity(product.getQuantity());
         existingProduct.setPrice(product.getPrice());
         return productRepository.save(existingProduct);
     }
     
     public Product findByNameAndId(String name, int id){
     
         return productRepository.findByNameAndId(name, id);
     }
    
    
}
