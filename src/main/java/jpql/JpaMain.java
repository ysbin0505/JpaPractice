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
      Member member = new Member();
      member.setUsername("member1");
      member.setAge(10);
      em.persist(member);

      TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
      //TypedQuery<String> stringTypedQuery = em.createQuery("select m.username from Member m", String.class);
      //Query query2 = em.createQuery("select m.username, m.age from Member m", Member.class); //반환 타입이 명확X
      List<Member> resultList = query.getResultList();
      for (Member member1 : resultList) {
        System.out.println("member1 = " + member1);
      }

      //Member result = query.getSingleResult();    //-> 반환할것이 하나일때
      //System.out.println("result = " + result);

      em.flush();

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
