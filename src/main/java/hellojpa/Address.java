package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Address {
  @Id @GeneratedValue
  private Long id;

  private String address;

  public Address() {
    
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address1 = (Address) o;
    return Objects.equals(id, address1.id) && Objects.equals(address, address1.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address);
  }
}
