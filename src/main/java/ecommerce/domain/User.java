package ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  @Column (nullable= false, length = 50)
  private String name;

  @Column (nullable= false)
  private int items;


  public User() {
  }

  public User(String name, int items) {
    this.name = name;
    this.items = items;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public int getItems() {
    return items;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setItems(int items) {
    this.items = items;
  }

  

  
  
}
