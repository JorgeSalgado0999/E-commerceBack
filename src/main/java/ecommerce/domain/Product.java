package ecommerce.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (nullable= false, length = 50)
  private String name;

  @Column (nullable= false, length = 255)
  private String description;

  @Column (nullable= false  )
  private Double price;

  @ManyToOne
  private User user;

  @JsonIgnore
  @ManyToOne
  private Category category;

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

  public Product() {
  }

  public Product(String name, String description, Double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
  
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  

  
}
