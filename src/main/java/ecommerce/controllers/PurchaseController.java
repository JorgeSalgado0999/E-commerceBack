package ecommerce.controllers;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bl.PurchaseService;
import ecommerce.domain.Purchase;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase")
    public ResponseEntity<Object> createPurchase(
            @RequestParam Integer buyerId,
            @RequestParam Integer sellerId,
            @RequestParam Integer productId
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            Purchase purchase = purchaseService.createPurchase(buyerId, sellerId, productId);
            response.put("status", 200);
            response.put("data", Collections.singletonMap("response", "Purchase created successfully"));
            response.put("id", purchase.getId());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("response", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/purchase/seller/{id}")
    public ResponseEntity<Object> getPurchasesBySellerId(@PathVariable(value = "id") Integer sellerId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Purchase> purchases = purchaseService.getPurchasesBySellerId(sellerId);
            response.put("status", 200);
            response.put("data", Collections.singletonMap("response", purchases));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("response", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/purchase/buyer/{id}")
    public ResponseEntity<Object> getPurchasesByBuyerId(@PathVariable(value = "id") Integer buyerId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Purchase> purchases = purchaseService.getPurchasesByBuyerId(buyerId);
            response.put("status", 200);
            response.put("data", Collections.singletonMap("response", purchases));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("response", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

