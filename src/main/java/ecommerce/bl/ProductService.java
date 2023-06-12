package ecommerce.bl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dl.ProductRepository;
import ecommerce.domain.Category;
import ecommerce.domain.Product;
import ecommerce.domain.User;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository repo;

  @Autowired
  private UserService userService;
  
  @Autowired
  private CategoryService categoryService;

  public Product createProduct(Product product, Integer user_id, Integer category_id) {
    System.out.println("Validating User: " + user_id);
    if (user_id == null) {
      throw new RuntimeException("User is required");
    }
    User userOwner = userService.getUser(user_id);
    System.out.println("User Owner: " + userOwner);
    product.setUser(userOwner);

    System.out.println("Validating Category: ");
    if (category_id == null) {
      throw new RuntimeException("Category is required");
    }
    Category categoryProduct = categoryService.getCategorById(category_id);
    product.setCategory(categoryProduct);

    System.out.println("Creating Product: ");
    return repo.save(product);
  }   

  public List<Product> getAllProducts() {
    System.out.println("Getting Products: ");
    return repo.findAll();
  }

  public Product getProductById(Integer id) {
    Optional<Product> optionalProduct = repo.findById(id);
    if (optionalProduct.isPresent()) {
      return optionalProduct.get();
    } else {
      throw new RuntimeException("Product not found");
    }
  }
  public List<Product> getProductsByUser(Integer userId) {
    User user = userService.getUser(userId);
    List<Product> userProducts = user.getProducts();
    return userProducts;
  }

  public Product updateProduct(Product updatedProduct) {
    if (updatedProduct.getId() != null) {
    Optional<Product> optionalProduct = repo.findById(updatedProduct.getId());
    if (optionalProduct.isPresent()) {
      Product existingProduct = optionalProduct.get();
      existingProduct.setName(updatedProduct.getName());
      existingProduct.setDescription(updatedProduct.getDescription());
      // existingProduct.setCategory(updatedProduct.getCategory());
      System.out.println("Updating Product: ");
      return repo.save(existingProduct);
      } else {
        throw new RuntimeException("Product not found");
      }
    } else {
      throw new RuntimeException("Invalid product ID");
    }
  }

  public void deleteProduct(Integer id) {
    Optional<Product> optionalProduct = repo.findById(id);
    if (optionalProduct.isPresent()) {
        Product product = optionalProduct.get();
        System.out.println("Deleting Product: ");
        repo.delete(product);
    } else {
        throw new RuntimeException("Product not found");
    }
  }

}
