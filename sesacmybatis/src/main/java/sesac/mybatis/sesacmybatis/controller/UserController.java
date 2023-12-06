package sesac.mybatis.sesacmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sesac.mybatis.sesacmybatis.domain.User;
import sesac.mybatis.sesacmybatis.dto.UserDTO;
import sesac.mybatis.sesacmybatis.service.UserService;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/")
  public String getUsers(Model model) {
    List<UserDTO> users = userService.gerUserList();
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
}
