package hellojpa.jpashop;

import hellojpa.jpashop.domain.Member;
import jakarta.persistence.*;

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

            TypedQuery<Member> query = em.createQuery("select m from Member as m where m.id =10L", Member.class);
            TypedQuery<String> query1 = em.createQuery("select m.username from Member as m", String.class);
            Query query2 = em.createQuery("select m.username,m.age from Member as m");
            System.out.println(query.getSingleResult().getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();
    }
}
