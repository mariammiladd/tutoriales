package com.init.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.product.entities.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
