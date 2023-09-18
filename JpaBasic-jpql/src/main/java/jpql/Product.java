package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
  @Id @GeneratedValue
  private Long id;
  private String name;
  private int price;
  private int stockAmunt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStockAmunt() {
    return stockAmunt;
  }

  public void setStockAmunt(int stockAmunt) {
    this.stockAmunt = stockAmunt;
  }
}
