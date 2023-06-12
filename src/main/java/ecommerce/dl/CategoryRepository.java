package ecommerce.dl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.domain.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
  
}
