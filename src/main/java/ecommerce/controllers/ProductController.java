package ecommerce.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bl.ProductService;
import ecommerce.domain.Product;

@RestController
public class ProductController {

  @Autowired
  private ProductService service;


  @PostMapping("/products")
  public ResponseEntity<Object> createProduct(@RequestBody Product product, @RequestParam Integer user_id,
      @RequestParam Integer category_id) {
    Map<String, Object> response = new HashMap<>();
    try {
      Product newProduct = service.createProduct(product, user_id, category_id);
      response.put("status", 200);
      response.put("data", Collections.singletonMap("response", "Product created successfully"));
      response.put("id", newProduct.getId());
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      response.put("status", "error");
      response.put("response", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }
  
  @GetMapping("/products")
  public ResponseEntity<Object> getAllProducts() {
    Map<String, Object> response = new HashMap<>();
    try {
      List<Product> products = service.getAllProducts();
      response.put("status", 200);
      response.put("data", Collections.singletonMap("response", products));
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      response.put("status", "error");
      response.put("response", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Object> getProduct(@PathVariable(value = "id") Integer id) {
    Map<String, Object> response = new HashMap<>();
    try {
      Product product = service.getProductById(id);
      response.put("status", 200);
      response.put("data", Collections.singletonMap("response", product));
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      response.put("status", "error");
      response.put("response", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable(value = "id") Integer id) {
    Map<String, Object> response = new HashMap<>();
    try {
      product.setId(id);
      Product updatedProduct = service.updateProduct(product);
      response.put("status", 200);
      response.put("data", Collections.singletonMap("response", "Product updated successfully"));
      response.put("id", updatedProduct.getId());
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      response.put("status", "error");
      response.put("response", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Integer id) {
    Map<String, Object> response = new HashMap<>();
    try {
      service.deleteProduct(id);
      response.put("status", 200);
      response.put("data", Collections.singletonMap("response", "Product deleted successfully"));
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      response.put("status", "error");
      response.put("response", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  

}
