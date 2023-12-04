package mapper;


import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
//    sql과 객체를 매핑해주는 곳 => 실제 db에 접속할 때 실행할 sql문을 정의

//    1. xml 파일을 참고한다.
    List<User> retrieveAll();


//    2. xml 파일을 참고하지 않고 직접 sql을 작성하겠다.
    @Insert("insert into user(name, nickname) values (#{name}, #{nickname})")
    void insertUser(User user);
//    void insertUser(String name, String nickname)

}
