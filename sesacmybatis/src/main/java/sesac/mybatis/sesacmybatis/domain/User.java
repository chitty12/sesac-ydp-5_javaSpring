package sesac.mybatis.sesacmybatis.domain;

import lombok.Getter;
import lombok.Setter;

// 실제 데이터의 역할 = 테이블의 구조
// mapper = sql과 결과를 객체로 매핑해주는 친구 = 매핑되는 객체
@Getter
@Setter
public class User {
  private int id;
  private String name;
  private String nickname;
}
