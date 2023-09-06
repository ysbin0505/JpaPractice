package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "CATEGORY_ITEM")
  @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"),
  inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
  private List<Item> items = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  private int stockQuantity;

  @OneToMany(mappedBy = "parent")
  private List<Category> child = new ArrayList<>();
}
