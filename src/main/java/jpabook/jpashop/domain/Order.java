package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ORDERS")     //DB에서 ORDER BY 정렬 때문에 인식이 안되는 DB가 종종 발생해서 ORDERS로 명명
@Getter @Setter
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)

  private Long id;

  private Long memberId;
  private LocalDateTime orderDate;
  @Enumerated(EnumType.STRING)      //ENUM타입은 이거 써주자 + ORDINARY 안씀 -> 순서꼬임
  private OrderStatus status;
}
