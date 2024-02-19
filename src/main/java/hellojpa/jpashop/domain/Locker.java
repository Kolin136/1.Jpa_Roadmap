package hellojpa.jpashop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Locker {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToOne(mappedBy = "locker")
  private Member member;

}
