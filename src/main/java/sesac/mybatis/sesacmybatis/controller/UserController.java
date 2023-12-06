package sesac.mybatis.sesacmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.mybatis.sesacmybatis.domain.User;
import sesac.mybatis.sesacmybatis.dto.UserDTO;
import sesac.mybatis.sesacmybatis.entity.UserEntity;
import sesac.mybatis.sesacmybatis.service.UserService;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/")
  public String getUsers(Model model) {
//    List<UserDTO> users = userService.gerUserList();

    List<UserDTO> users = userService.getUserList2();
    model.addAttribute("list", users);
    // userdto 에는 id, name, nickname, no
    return "user";
  }

  @GetMapping("user")
  public String getUserInsert(@RequestParam String name, @RequestParam String nickname, Model model){
    User user = new User();
    user.setName(name);
    user.setNickname(nickname);

    userService.insertUser(user);

    return "redirect:/";
  }

//  @GetMapping("search")
//  @ResponseBody
//  public String getUserByName(@RequestParam String name) {
//    // ? 뒤에 쿼리로 받아온 name 값으로 검색을 해서 검색된 객체의 아이디와 닉네임을 보여주겠다.
//    UserEntity user = userService.getUserByName(name);
//    return user.getId() + " : " + user.getNickname();
//  }
  
  // 1. 검색어로 이름이 일치하는 거 조회 -> 일치하는 사용자가 몇 명인지 출력

  @GetMapping("search")
  @ResponseBody
  public String searchUser(@RequestParam String name) {
    return userService.searchUser(name);
  }
  // 2. 검색어를 받은 다음, 이름과 일치하거나 닉네임과 일치하는 사용자가 몇명인지 출력
  @GetMapping("find")
  @ResponseBody
  public String findUser(@RequestParam String name) {
    return userService.findUser(name);
  }
  // 3. 이름을 받았을 때 그 이름의 사용자가 존재하는지 유무 체크
  @GetMapping("check")
  @ResponseBody
  public String checkUser(@RequestParam String name ) {
    return userService.checkUser(name);
  }
}
