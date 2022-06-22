package jpabook.jpashop;

import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
//            Member member = new Member();


//            em.persist();
            tx.commit();
        } catch (Exception e) {
            System.out.println("catch");
            tx.rollback();
        }finally {
            System.out.println("finally");
            em.close();
        }
        emf.close();




    }



}
