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

      Team teamA = new Team();
      teamA.setName("팀A");
      em.persist(teamA);

      Team teamB = new Team();
      teamB.setName("팀B");
      em.persist(teamB);

      Member member1 = new Member();
      Member member2 = new Member();
      Member member3 = new Member();
      member1.setUsername("회원1");
      member1.setAge(10);
      member2.setUsername("회원2");
      member2.setAge(5);
      member3.setUsername("회원3");
      member3.setAge(9);

      member1.setTeam(teamA);
      member2.setTeam(teamA);
      member3.setTeam(teamB);

      em.persist(member1);
      em.persist(member2);    //persist를 해야 DB반영
      em.persist(member3);

      em.flush();
      em.clear();

      String jpql = "select m from Member m join fetch m.team";
      List<Member> members = em.createQuery(jpql, Member.class).getResultList();

      for (Member member : members) {
        System.out.println("username = " + member.getUsername() + ", " +
            "teamName = " + member.getTeam().getName());
        //회원1, 팀A(SQL)
        //회원2, 팀A(1차캐시)
        //회원3, 팀B(SQL)
        //회원이 100명이면 쿼리는 100+1 <N+1>
        //fetch 쓰면 쿼리 한방에 나옴
      }

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
