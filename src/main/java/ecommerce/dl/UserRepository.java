package ecommerce.dl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  
  User findByEmail(String email);
}
