package jpabook.jpashop.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Member {
  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;    //id
  private String name;    //회원명

  @Embedded
  private Address address;    //주소

  @OneToMany(mappedBy = "member")   //연관관계의 주인이 아니다.
  private List<Order> orders = new ArrayList<>();
}