package ecommerce.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (nullable= false, length = 60)
  private String firstName;
  @Column (nullable= false, length = 60)
  private String lastName;

  @Column (nullable= false)
  private int age;

  @Column (nullable= false, length = 40)
  private String nickName;

  @Column(nullable = false, length = 50)
  private String email;
  @Column(nullable = false, length = 50)
  private String password;

  @Column(nullable = false, length = 50)
  private String phone;

  @Column(nullable = true, length = 50)
  private String country;
  @Column(nullable = true, length = 50)
  private String state;
  @Column(nullable = true, length = 50)
  private String city;
  @Column(nullable = true, length = 50)
  private String street;
  @Column(nullable = true, length = 50)
  private String externalNumber;
  @Column(nullable = true, length = 50)
  private String internalNumber;
  @Column(nullable = true, length = 50)
  private String suburb;
  @Column(nullable = true, length = 50)
  private String zipCode;

  @OneToMany(mappedBy = "user")
  private List<Product> products;

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


  public User() {
  }

  public User(String firstName, String lastName, int age, String nickName, String email,
      String password, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.nickName = nickName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.country = "Mexico";
  }

  public Integer getUserId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public String getNickName() {
    return this.nickName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getCountry() {
    return this.country;
  }

  public String getState() {
    return this.state;
  }

  public String getCity() {
    return this.city;
  }

  public String getStreet() {
    return this.street;
  }

  public String getExternalNumber() {
    return this.externalNumber;
  }

  public String getInternalNumber() {
    return this.internalNumber;
  }

  public String getSuburb() {
    return this.suburb;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public void setUserId(Integer id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setExternalNumber(String externalNumber) {
    this.externalNumber = externalNumber;
  }

  public void setInternalNumber(String internalNumber) {
    this.internalNumber = internalNumber;
  }

  public void setSuburb(String suburb) {
    this.suburb = suburb;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  
  

  
  
}
