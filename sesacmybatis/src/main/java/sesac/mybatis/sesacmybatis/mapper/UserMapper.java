package sesac.mybatis.sesacmybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.mybatis.sesacmybatis.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
  // sql과 객체를 매핑해주는 곳 -> 실제로 db에 접속할 때 실행할 sql문을 정의

  // 1. xml 파일을 참고하겠다.
  List<User> retreiveAll(); // select

  // 2. xml 파일을 참고하지 않고 직접 sql을 작성하겠다.
  @Insert("insert into user2(name, nickname) values(#{name}, #{nickname})")
  void insertUser(User user);
  // void insertUser(String name, String nickname)
}
