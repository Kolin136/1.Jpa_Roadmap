package hellojpa.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="ORDER_ID")
  private Order order;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="ITEM_ID")
  private Item item;

  private int orderPrice;
  private int count;

  public void setId(Long id) {
    this.id = id;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public void setOrderPrice(int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Long getId() {
    return id;
  }

  public Order getOrder() {
    return order;
  }

  public Item getItem() {
    return item;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public int getCount() {
    return count;
  }
}
