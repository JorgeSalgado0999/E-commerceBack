package ecommerce.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import ecommerce.domain.Product;

@RestController
public class AppController {


  @GetMapping("/")
  public ResponseEntity<Object> getAllProducts() {
    String text = "Hello World";

    Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("data", Collections.singletonMap("repsonse", text));
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
