package sesac.mybatis.sesacmybatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sesac.mybatis.sesacmybatis.entity.UserEntity;

import java.util.List;
import java.util.Optional;

// Repository : 만들어진 DB 구조에 CRUD 하기 위해 필요한 메소드를 정의하는 계층
// JpaRepository<대상으로 지정할 Eentity, 해당 Entity의 pk타입>
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  // Optional : java 8 이후부터 등장한 친구
  // null일 수도 있는 객체를 감싸는 wrapper 클래스
  // Optional<T> : null일 수도 있는 단일값을 표현할 때 사용하는 것이 권장됨


  // findBy를 이용하고 단일값으로 받으면 ( UserEntity, Optional<UserEntity> )
  // 검색된 값이 2개 이상일 때 에러가 난다.
  // List<UserEntity> findBy컬럼명
  List<UserEntity> findByName(String name);

  List<UserEntity> findByNameOrNickname(String name, String nickname);

  @Query(nativeQuery = true, value="select * from user2 where name=:name or nickname=:name")
  List<UserEntity> findSelf(String name);

  boolean existsByName(String name);

  // findBy뒤에는 컬럼명이 upeer case 된 형태로 들어온다.

  UserEntity findByNickname(String nickname); // 조건에 nickname을 걸어서 실행하겠다.




  //@Query("select u from UserEntity u where u.name=:asdf and u.nickname=:nickname")
  @Query(nativeQuery = true, value="select * from user where name=:asdf and nickname=:nickname")
  UserEntity findByNameAndNickName(String asdf, String nickname);
  //findByNameAndNickname : jpa 규칙에 부합
}
