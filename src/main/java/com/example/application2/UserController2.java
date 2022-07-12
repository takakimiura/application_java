package com.example.application2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController2 {
  @Autowired
  private UserRepository2 userRepository2;

  @RequestMapping("/user/list")
  public String list(Model m) {

    m.addAttribute("userList", userRepository2.findAllOrderByIdDesc()); //idを降順で表示させる

    return "user/list";
  }

  @RequestMapping("/user/{id}")
  public String show(Model m,
  @PathVariable int id
  ) {
    UserEntity2 s = userRepository2.findById(id).get();
    m.addAttribute("userData", s);

    return "user/show";

  }

  @RequestMapping("/user/new")
  public String usernew(Model m) {

    m.addAttribute("userData", new UserEntity2()) ;

    return "user/new";
  }

  @RequestMapping("/user/create")
  public String create(Model m,
  @ModelAttribute UserEntity2 user 
  ) {

    m.addAttribute("userData", user);

    userRepository2.save(user);

    return "redirect:/user/list";
  }

  @RequestMapping("/user/{id}/edit")
  public String useredit(Model m,
  @PathVariable int id
  ) {
    m.addAttribute("userData", userRepository2.findById(id).get());

    return "/user/edit";

  }


}
