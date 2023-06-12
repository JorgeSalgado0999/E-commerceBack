package ecommerce.dl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.domain.Cart;
import ecommerce.domain.Purchase;
import ecommerce.domain.User;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findBySeller(User seller);
    List<Purchase> findByBuyer(User buyer);

}
