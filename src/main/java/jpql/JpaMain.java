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
      Member member2 = new Member();
      member.setUsername("member1");
      member.setAge(10);
      member2.setUsername("member2");
      member2.setAge(5);
      em.persist(member);
      em.persist(member2);    //persist를 해야 DB반영

      em.flush();
      em.clear();

      /*TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
      //TypedQuery<String> stringTypedQuery = em.createQuery("select m.username from Member m", String.class);
      //Query query2 = em.createQuery("select m.username, m.age from Member m", Member.class); //반환 타입이 명확X
      List<Member> resultList = query.getResultList();
      for (Member member1 : resultList) {
        System.out.println("member1 = " + member1);*/
      /*List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
      Member findMember = result.get(1);    //INdex1번 값을 고치는 의미
      findMember.setAge(20);*/

      //Member result = query.getSingleResult();    //-> 반환할것이 하나일때
      //System.out.println("result = " + result);

/*      List resultList = em.createQuery("select m.username, m.age from Member m").getResultList();
      Object o = resultList.get(0);
      Object[] result = (Object[]) o;
      System.out.println("result = " + result[0]);
      System.out.println("result = " + result[1]);
*/    //Object[]타입으로 여러 값 조회하는 방법

      List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();
      MemberDTO memberDTO = resultList.get(0);
      System.out.println("memberDTO = " + memberDTO.getUsername());
      System.out.println("memberDTO = " + memberDTO.getAge());


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
