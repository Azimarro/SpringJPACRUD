/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.JpaCRUD.repository;

import com.example.JpaCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Azim Isroilov
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
Product findByName(String name);

Product findByNameAndId(String name, int id);

}
