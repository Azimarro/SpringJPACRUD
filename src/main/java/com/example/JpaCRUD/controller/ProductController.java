/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JpaCRUD.controller;

import com.example.JpaCRUD.entity.Product;
import com.example.JpaCRUD.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Azim Isroilov
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
    return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
    return service.saveProducts(products);
    }
    
    @GetMapping("/products")
    public List<Product> findAllProducts(){
    return service.getProducts();
    }
    
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
    return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
    return service.getProductByName(name);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
    
    return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
            return service.deleteProduct(id);
      }
    
    @RequestMapping(method = RequestMethod.GET, value ="/getnameid")
    public Product getNameId(@RequestParam(value = "name")String name,
                             @RequestParam(value = "id")int id){
        return service.findByNameAndId(name, id);
    }
    
}
