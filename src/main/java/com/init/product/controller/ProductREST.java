package com.init.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.product.dao.ProductDAO;
import com.init.product.entities.Product;

@RestController
@RequestMapping("products")
public class ProductREST {
	@Autowired
	private ProductDAO productDAO;

	// @GetMapping //el metodo esta en la raiz
	// @RequestMapping(value="hello",method=RequestMethod.GET) //el metodo esta en
	// raiz/hello
	// public String hello() {
	// return "Hello world";
	// }

	@GetMapping
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
	}

	@RequestMapping(value = "{productId}") // products/{productId} -> /products/1
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
		Optional<Product> product = productDAO.findById(productId);
		if (!product.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(product.get());
		}
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}

	@DeleteMapping(value = "{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Optional<Product> opcionalProduct = productDAO.findById(product.getId());
		if (!opcionalProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			Product updateProduct = opcionalProduct.get();
			updateProduct.setName(product.getName());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}
	}
}
