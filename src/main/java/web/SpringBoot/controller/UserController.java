package web.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.SpringBoot.model.User;
import web.SpringBoot.service.UserService;


@Controller
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String showAll(Model model) {
        model.addAttribute("user", userService.showAll());
        return "index";
    }

    @GetMapping("/user/new")
    public String addUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/user")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        System.out.println("!!!!!!!!");
        return "redirect:/user";
    }

//    @DeleteMapping("/user/{id}")
    @GetMapping("/user/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
