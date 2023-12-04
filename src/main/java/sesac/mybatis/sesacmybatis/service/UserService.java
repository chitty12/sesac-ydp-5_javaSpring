package sesac.mybatis.sesacmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.mybatis.sesacmybatis.domain.User;
import sesac.mybatis.sesacmybatis.dto.UserDTO;
import sesac.mybatis.sesacmybatis.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  @Autowired // 의존성 주입, 내가 원하는 객체를 사용할 수 있게 해준다.
  UserMapper userMapper;

  public List<UserDTO> gerUserList(){
    // controller에서 전체 조회를 시켰다.
    // mapper의 retrieveAll 이라는 메소드를 실행할 것.

    List<User> users = userMapper.retreiveAll();
    List<UserDTO> result = new ArrayList<>();

    for ( User user : users) {
      // retreiveAll 을 실행해 나온 List<User> 값을 for문을 통해 UserDTO로 값을 옮기고,
      // return 하기 위해 만든 result List에 add한 후 return 한다.
//      UserDTO userdto = new UserDTO();
//      userdto.setId(user.getId());
//      userdto.setName(user.getName());
//      userdto.setNickname(user.getNickname());
//      userdto.setNo(user.getId() + 10);

      UserDTO userdto = UserDTO.builder()
          .id(user.getId())
          .no(user.getId() + 10)
          .name(user.getName())
          .nickname(user.getNickname())
          .build();

      result.add(userdto);
    }

    return result;
  }

  public void insertUser(User user) {
    userMapper.insertUser(user);
  }
}
