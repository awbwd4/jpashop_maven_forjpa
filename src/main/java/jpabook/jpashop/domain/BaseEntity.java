package jpabook.jpashop.domain;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {


    @Column(name="INSERT_MEMBER")
    private String createdBy;
    private LocalDateTime createdDate;
    @Column(name="UPDATE_MEMBER")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;


}
