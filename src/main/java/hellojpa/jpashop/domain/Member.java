package hellojpa.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;
  private String name;
  private String city;
  private String steet;
  private String zipcode;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getSteet() {
    return steet;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setSteet(String steet) {
    this.steet = steet;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}
