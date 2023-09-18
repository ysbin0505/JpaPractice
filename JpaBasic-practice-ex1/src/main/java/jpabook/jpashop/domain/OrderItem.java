package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORDER_ITEM_ID")
  private int id;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  private int orderPrice;
  private int count;
}
