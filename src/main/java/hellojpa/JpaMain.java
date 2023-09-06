package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try{
      /*Member member = new Member();
      member.setId(2L);
      member.setName("HelloB");     -> 여기까지 비영속
      em.persist(member);           -> 여기서부터 영속          */

      /*Member findMember = em.find(Member.class, 1L);
      findMember.setName("HelloJPA");

      em.persist(findMember);   -> 생략 가능*/

      List<Member> result = em.createQuery("select m from Member as m", Member.class)
              .setFirstResult(5).setMaxResults(8).getResultList();    //페이징이 엄청 간편함

      tx.commit();    //comit 이후에 데베에 보냄
    } catch (Exception e){
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }

  private static void printMemberAndTeam(Member member){
    String username = member.getUsername();
    System.out.println("username = " + username);

    Team team = member.getTeam();
    System.out.println("team = " + team.getName());
  }
}
