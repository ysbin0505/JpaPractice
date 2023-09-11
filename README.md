# JpaBasic-jpql
jpql공부


*여러 값 조회 방법

1. Query 타입으로 조회
   TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
      //TypedQuery<String> stringTypedQuery = em.createQuery("select m.username from Member m", String.class);
      //Query query2 = em.createQuery("select m.username, m.age from Member m", Member.class); //반환 타입이 명확X
      List<Member> resultList = query.getResultList();
      for (Member member1 : resultList) {
        System.out.println("member1 = " + member1);*/
      /*List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
      Member findMember = result.get(1);    //INdex1번 값을 고치는 의미
      findMember.setAge(20);

      //Member result = query.getSingleResult();    //-> 반환할것이 하나일때
      //System.out.println("result = " + result);

2. Object[] 타입으로 조회
 List resultList = em.createQuery("select m.username, m.age from Member m").getResultList();
      Object o = resultList.get(0);
      Object[] result = (Object[]) o;
      System.out.println("result = " + result[0]);
      System.out.println("result = " + result[1]);    //  ->  Object[]타입으로 여러 값 조회하는 방법

3. new 명령어로 조회
   List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();    // -> MemberDTO 생성시 순서와 타입이 일치하는 생성자 필요
      MemberDTO memberDTO = resultList.get(0);
      System.out.println("memberDTO = " + memberDTO.getUsername());
      System.out.println("memberDTO = " + memberDTO.getAge());

   
*페이징 API
for (int i=0; i<100;  i++){
        Member member = new Member();
        member.setUsername("member" + i);
        member.setAge(i);
        em.persist(member);
      }

      /*Member member2 = new Member();
      member2.setUsername("member2");
      member2.setAge(5);
      em.persist(member2);    //persist를 해야 DB반영
*/
      em.flush();
      em.clear();

      List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
          .setFirstResult(0)
          .setMaxResults(10)
          .getResultList();
      System.out.println("result.size = " + result.size());
      for (Member member1 : result) {
        System.out.println("member1 = " + member1);
      }

      tx.commit();

      
