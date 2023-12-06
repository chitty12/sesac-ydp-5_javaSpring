package sesac.mybatis.sesacmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.mybatis.sesacmybatis.domain.User;
import sesac.mybatis.sesacmybatis.dto.UserDTO;
import sesac.mybatis.sesacmybatis.entity.UserEntity;
import sesac.mybatis.sesacmybatis.mapper.UserMapper;
import sesac.mybatis.sesacmybatis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired // 의존성 주입, 내가 원하는 객체를 사용할 수 있게 해준다.
  UserMapper userMapper;

  @Autowired
  UserRepository userRepository;

  public List<UserDTO> getUserList2() {
    // repository 에서 전체 조회 가능하도록 만들어볼 거다.
    List<UserEntity> users = userRepository.findAll();
    List<UserDTO> result = new ArrayList<>();

    for ( UserEntity user : users) {
      UserDTO userDTO = UserDTO.builder()
          .id(user.getId())
          .name(user.getName())
          .nickname(user.getNickname())
          .build();
      result.add(userDTO);
    }

    return result;
  }
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
//    userMapper.insertUser(user);

    UserEntity userEntity = new UserEntity();
    userEntity.setNickname(user.getNickname());
    userEntity.setName(user.getName());

    userRepository.save(userEntity);
    // save() : insert 할 때
    // save() : 새로운 entity를 insert 할 때 or 기존 entity를 update 할 때 사용
    // 기본값(pk)의 상태에 따라 다르게 동작
    // - pk 값이 존재하는 경우 : pk와 연결된 entity update
    // - pk 값이 없는 경우 : 새로운 entity insert
    // jpa에서 save(T)
  }

//  public UserEntity getUserByName(String name) {
//    UserEntity user = userRepository.findByName(name)
//        .orElseThrow(()-> new RuntimeException("no user"));
//    return user;
////    Optional<UserEntity> user = userRepository.findByName(name);
////    return user.orElse(null);
//    // orElse() : 값이 있으면 get()해서 값을 보내고, 없으면 () 있는 설정된 값을 보낸다.
////    if ( user.isPresent() ) {
////      return user.get(); // UserEntity
////    } else {
////      return null;
////    }
//  }

  public String searchUser(String name) {
    // 넘어온 이름과 일치하는 사용자가 "몇명인지" 를 받아와야 한다. -> List<UserEntity>
    List<UserEntity> users = userRepository.findByName(name);
    return users.size() + "명입니다.";
  }
  public String findUser(String name ){
    // 넘어온 이름과 이름이 일치하거나 닉네임이 일치하는 사용자가 "몇명인지" 반환한다.
    List<UserEntity> users = userRepository.findByNameOrNickname(name, name);
    return users.size() + "명입니다.";
  }
  public String checkUser(String name) {
    boolean isExist = userRepository.existsByName(name);
    if ( isExist ) return "있습니다.";
    else return "없습니다.";
  }
}
