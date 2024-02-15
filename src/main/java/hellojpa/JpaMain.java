package hellojpa;

import com.example.ex1hellojpa.hellojpa.Member;
import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
            Member member = new Member();
            member.setId(101L);
            member.setName("check2");
            em.persist(member);

            em.flush();
            System.out.println("===============================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
