package controller;


import domain.User;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUsers(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

//    @GetMapping("user")
//    public String getUserInsert(@RequestParam String name, @RequestParam String nickname, Model model){
//        User user = new User();
//        user.setName(name);
//        user.setNickname(nickname);
//
//        userService.insertUser(user);
//        return "redirect:/";
//
//    }
}
