package ecommerce.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dl.PurchaseRepository;
import ecommerce.domain.Product;
import ecommerce.domain.Purchase;
import ecommerce.domain.User;

@Service
public class PurchaseService {

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private ProductService productService;

  public Purchase createPurchase(Integer buyerId, Integer sellerId, Integer productId) {
    User buyer = userService.getUser(buyerId);
    User seller = userService.getUser(sellerId);
    Product product = productService.getProductById(productId);

    Purchase purchase = new Purchase(buyer, seller, product);
    return purchaseRepository.save(purchase);
  }

  public List<Purchase> getPurchasesBySellerId(Integer sellerId) {
    User seller = userService.getUser(sellerId);
    return purchaseRepository.findBySeller(seller);
  }

  public List<Purchase> getPurchasesByBuyerId(Integer buyerId) {
    User buyer = userService.getUser(buyerId);
    return purchaseRepository.findByBuyer(buyer);
  }
}