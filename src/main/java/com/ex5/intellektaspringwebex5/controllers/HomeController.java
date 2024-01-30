package com.ex5.intellektaspringwebex5.controllers;

import com.ex5.intellektaspringwebex5.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final User user;

    public HomeController(User user) {
        this.user = user;
    }

    @GetMapping("/")
    public String homeGet() {
        return "home.html";
    }

    @PostMapping("/")
    public String homePost(@RequestParam String username) {
        user.setUsername(username);
        return "redirect:/main";
    }


}
