package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Item_ID")
  private Long id;

  @OneToMany(mappedBy = "item")
  private List<OrderItem> orderItems = new ArrayList<>();

  private String name;
  private int price;
  private int stockQuantity;

}
