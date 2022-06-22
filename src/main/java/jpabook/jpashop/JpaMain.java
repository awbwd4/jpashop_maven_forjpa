package jpabook.jpashop;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

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
            // 멤버, 주문, 아이템 생성
            Member member = new Member();
            member.setName("m1");
            em.persist(member);


            Item item = new Item();
            item.setName("jpa");
            item.setPrice(10000);
            item.setStockQuantity(100);
            em.persist(item);

            /*아이템 주문*/

            //주문 객체 생성
            Order order = new Order();
            order.setMember(member);

            OrderItem orderItem = new OrderItem(order, item, 10000, 10);

            em.persist(orderItem);

            order.addOrderItem(orderItem);

            em.persist(order);

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
