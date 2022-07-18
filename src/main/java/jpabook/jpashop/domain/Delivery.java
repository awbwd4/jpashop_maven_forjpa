package jpabook.jpashop.domain;


import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    private Address address;

    private DeliveryStatus status;

}
