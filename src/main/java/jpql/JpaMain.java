package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Team team = new Team();
      team.setName("teamA");
      em.persist(team);

      Member member = new Member();
      Member member2 = new Member();
      member.setUsername("member1");
      member.setAge(10);
      member2.setUsername("member2");
      member2.setAge(5);

      member.setTeam(team);


      em.persist(member);
      em.persist(member2);    //persist를 해야 DB반영

      em.flush();
      em.clear();

      String query = "select m from Member m, Team t where m.username = t.name";
      List<Member> result = em.createQuery(query, Member.class).getResultList();

      tx.commit();
    } catch (Exception e){
      tx.rollback();
      e.printStackTrace();
    }finally {
      em.close();
    }
    emf.close();
  }
}
