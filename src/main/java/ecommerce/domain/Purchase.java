package ecommerce.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="purchases")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "buyer_id", referencedColumnName = "id")
  private User buyer;
  @ManyToOne
  @JoinColumn(name = "seller_id", referencedColumnName = "id")
  private User seller;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  //
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  @PrePersist
  public void prePersist() {
      this.createdAt = LocalDateTime.now();
      this.updatedAt = LocalDateTime.now();
  }
  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
  
  public Purchase() {
  }

  public Purchase(User buyer, User seller, Product product) {
    this.buyer = buyer;
    this.seller = seller;
    this.product = product;
  }

  

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public User getBuyer() {
    return buyer;
  }
  public void setBuyer(User buyer) {
    this.buyer = buyer;
  }
  public User getSeller() {
    return seller;
  }
  public void setSeller(User seller) {
    this.seller = seller;
  }
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }  
  
}
