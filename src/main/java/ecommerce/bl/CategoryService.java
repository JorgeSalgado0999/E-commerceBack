package ecommerce.bl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dl.CategoryRepository;
import ecommerce.dl.ProductRepository;
import ecommerce.domain.Category;
import ecommerce.domain.Product;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository repo;

  public Category getCategorById(Integer id) {
    Optional<Category> optionalCategory = repo.findById(id);
    if (optionalCategory.isPresent()) {
        return optionalCategory.get();
    } else {
        throw new RuntimeException("Category not found");
    }
  }
}
