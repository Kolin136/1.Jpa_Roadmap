package hellojpa.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(
    name ="Member.findByUsername",
    query = "select m from Member as m where m.username = :username"
)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;
  private String username;
  private int age;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  public void changeTeam(Team team){
    this.team= team;
    team.getMembers().add(this);
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", age=" + age +
        '}';
  }
}
