package sesac.mybatis.sesacmybatis.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entity : DB에서 쓰이는 필드와 매핑이 되는 클래스 (DB 테이블과 대응되는 클래스)
@Entity // 해당 클래스가 Entity 라는 것을 알려준다.
@Table(name="user2") // 테이블 이름을 명시
@Getter
@Setter
public class UserEntity {
  @Id // pk라는 것을 알려주고,
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // 자동으로 키를 생성해주는데, 그때 사용하는 전략을 auto_increment로 하겠다.
  // ( mysql 에서 가장 많이 쓰이는 방식 )
  private int id;

  @Column(length = 25, nullable=false) // DB의 컬럼이다 라는 것을 알려준다.
  // name varchar(25) not null,
  private String name;

  @Column
//  @Column(columnDefinition = "TEXT")
  // nickname text
  private String nickname;

//  @Enumerated(EnumType.STRING)
//  private UserType type;
//  public enum UserType {
//    TEACHER, STUDENT
//  }
}

