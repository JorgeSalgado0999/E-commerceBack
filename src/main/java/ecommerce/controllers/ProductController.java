package ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bl.CartMethods;
import ecommerce.domain.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.User;

@RestController
public class ProductController {

  @Autowired
  private CartMethods service;


  @PostMapping("/api/product")
  public Product createProduct(@RequestBody Product product) {
    System.out.println("lo que llega primero: " + product);

    return service.createProduct(product);
  }

  @GetMapping("/api/product")
  public Iterable<Product> getAllProducts() {
    return service.getAllProducts();
  }


  
  @PostMapping("/api/user")
  public User createUser(@RequestBody User user) {
    System.out.println("lo que llega primero: " + user.getName());

    return service.createUser(user);
  }
  

  @PostMapping("/api/cart")
  public Cart createCart(@RequestBody Cart cart) {
    System.out.println("lo que llega primero: " + cart.toString());

    return service.createCart(cart);
  }

}
