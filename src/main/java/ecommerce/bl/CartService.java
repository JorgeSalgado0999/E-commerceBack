package ecommerce.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dl.CartRepository;
import ecommerce.dl.ProductRepository;
import ecommerce.domain.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.User;

@Service
public class CartService {

  @Autowired
  private CartRepository repo;

  @Autowired
  private UserService userService;
  @Autowired
  private ProductService productService;
  

  public Cart addItem(Integer userId, Integer productId) {
    Cart newCart = new Cart();

    Product product = productService.getProductById(productId);
    newCart.setProduct(product);

    User user = userService.getUser(userId);
    newCart.setUser(user);

    repo.save(newCart);

    return newCart;
    }

    public void deleteItem(Integer cartId) {
      Optional<Cart> optionalcart = repo.findById(cartId);
      if (optionalcart.isPresent()) {
          Cart cart = optionalcart.get();
          System.out.println("Deleting Product: ");
          repo.delete(cart);
      } else {
          throw new RuntimeException("Product not found");
      }
    }

    public List<Product> getItemsByUser(Integer userId) {
        User user = userService.getUser(userId);
        List<Cart> userCart = repo.findByUserId(user.getUserId());

        List<Product> items = new ArrayList<>();
        for (Cart cart : userCart) {
          Product currrent = cart.getProduct();
          System.out.println("Product: " + currrent);
          items.add(currrent);
        }

        return items;
    }
}
