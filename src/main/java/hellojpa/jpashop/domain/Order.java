package hellojpa.jpashop.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@Table(name="ORDERS")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORDER_ID")
  private Long id;
  private int orderAmount;
  @Embedded
  private Adress adress;
  @ManyToOne
  @JoinColumn(name="PRODUCT_ID")
  private Product product;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="MEMBER_ID")
  private Member member;
  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();


  public void setId(Long id) {
    this.id = id;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public Member getMember() {
    return member;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public OrderStatus getStatus() {
    return status;
  }
}
