package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Diary {
  @Id @GeneratedValue
  private Long id;

  private String loginId;
}
