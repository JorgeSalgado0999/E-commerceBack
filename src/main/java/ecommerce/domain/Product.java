package ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;

  @Column (nullable= false, length = 50)
  private String name;

  @Column (nullable= false, length = 255)
  private String description;

  @Column (nullable= false  )
  private Double price;

  public Product() {
  }
  public Product(String name, String description, Double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
  
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
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
}
