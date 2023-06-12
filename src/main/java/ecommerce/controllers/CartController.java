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

import ecommerce.bl.CartService;
import ecommerce.bl.ProductService;
import ecommerce.domain.Cart;
import ecommerce.domain.Product;

@RestController
public class CartController {

  @Autowired
  private CartService service;
  

  @PostMapping("/cart")
    public ResponseEntity<Object> createProduct(
            @RequestParam Integer user_id,
            @RequestParam Integer product_id
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cart newCart = service.addItem(user_id, product_id);
            response.put("status", 200);
            response.put("data", Collections.singletonMap("response", "Product created successfully"));
            response.put("id", newCart.getId());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("response", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable(value = "id") Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Product> product = service.getItemsByUser(id);
            response.put("status", 200);
            response.put("data", Collections.singletonMap("response", product));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("response", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.deleteItem(id);
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
