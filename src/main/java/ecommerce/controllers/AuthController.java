package ecommerce.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ecommerce.bl.UserService;
import ecommerce.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

  @Autowired
  private UserService service;
  
  @PostMapping("/auth")
  public ResponseEntity<Object> signup(@RequestBody User user) {
    Map<String, Object> response = new HashMap<>();
    Map<String, Object> responseData = new HashMap<>();
    try{
      User newObj = service.createUser(user);
      response.put("status", 200);
      responseData.put("response", "Usuario creado exitosamente");
      responseData.put("id", newObj.getUserId());
      response.put("data", responseData);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      System.out.println("Error Controller: " + e);
      response.put("status", "error");
      response.put("response", e.getMessage());
      // response.put("response", Collections.singletonMap("response",e.getMessage()));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  @GetMapping("/auth/{id}")
  public ResponseEntity<Object> getUser(@PathVariable(value = "id") String id) {
    Map<String, Object> response = new HashMap<>();
    
    try{
      User user = service.getUser(Integer.parseInt(id));
      response.put("status", 200);
      response.put("data", Collections.singletonMap("repsonse", user));
      return ResponseEntity.status(HttpStatus.OK).body(response);

    }catch(Exception e){
      System.out.println("Error Controller: " + e);
      response.put("status", "error");
      response.put("response", e.getMessage());
      // response.put("response", Collections.singletonMap("response",e.getMessage()));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }
  

  @PostMapping(value="/auth/{id}")
  public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable(value = "id") String id) {
      Map<String, Object> response = new HashMap<>();
    Map<String, Object> responseData = new HashMap<>();
    try{
      User newObj = service.updateUser(user, id);
      response.put("status", 200);
      responseData.put("response", "Usuario editado exitosamente");
      responseData.put("id", newObj.getUserId());
      response.put("data", responseData);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
      System.out.println("Error Controller: " + e);
      response.put("status", "error");
      response.put("response", e.getMessage());
      // response.put("response", Collections.singletonMap("response",e.getMessage()));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }
  
}
