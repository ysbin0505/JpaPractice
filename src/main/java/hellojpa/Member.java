package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MBR")
@Getter @Setter
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
                                            //Identity
                                            //sequence
                                            //table
  private Long id;
  @Column(name = "name")
  private String username;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;

  @Lob
  private String description;

  public Member(){

  }
}
