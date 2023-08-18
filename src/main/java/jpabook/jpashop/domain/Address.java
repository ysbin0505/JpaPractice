package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter   //값 타입은 변경 불가능하게 설계 -> @Setter 제거, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스 만들기.
public class Address {
  private String city;
  private String street;
  private String zipcode;

  protected Address(){
  }

  public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }
}
