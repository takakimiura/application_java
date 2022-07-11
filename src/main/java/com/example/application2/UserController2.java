package com.example.application2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController2 {
  @Autowired
  private UserRepository2 userRepository2;

  @RequestMapping("/user/list")
  public String list(Model m) {

    m.addAttribute("userList", userRepository2.findAll());

    return "user/list";
  }

}
