package sesac.mybatis.sesacmybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 생성자를 만드는 어노테이션 ( 모든 필드값을 사용하는 생성자 )
// @NoArgsConstructor : 기본 생성자를 만들어주는 어노테이션
// @RequiredArgsConstructor : final이나 @NotNull인 필드값만 사용하는 생성자
public class UserDTOBuilder {
  private final int id;
  private final String name, nickname;

  public static class Builder {
      private int id;
      private String name, nickname;
      public Builder id(int id){
        this.id = id;
        return this;
      }
      public Builder name(String name){
        this.name = name;
        return this;
      }
      public Builder nickname(String nickname) {
        this.nickname = nickname;
        return this;
      }
      public UserDTOBuilder build(){ return new UserDTOBuilder(id, name, nickname);}
  }
  public static Builder builder() { return new Builder(); }

}
