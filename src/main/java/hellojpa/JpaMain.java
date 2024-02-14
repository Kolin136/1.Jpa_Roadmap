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
            Member findMember = em.find(Member.class,3L);
            System.out.println("하하"+findMember.getName());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
