package hellojpa.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "DELIVERY_ID")
  private Long id;

  private String city;
  private String street;
  private String zipcode;
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
  private Order order;

}
