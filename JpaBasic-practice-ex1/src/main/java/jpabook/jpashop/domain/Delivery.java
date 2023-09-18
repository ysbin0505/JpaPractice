package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  private Order oder;

  private String city;
  private String street;
  private String zipcode;

}
