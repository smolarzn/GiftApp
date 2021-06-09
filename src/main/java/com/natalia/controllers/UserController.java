package com.natalia.controllers;

import com.natalia.services.UserService;
import com.natalia.types.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserTo());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserTo user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        logger.info("{},{},{}", user.getId(), user.getEmail(), user.getPassword());
        userService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/user/mainPage")
    public String mainPage() {
        return "user/mainPage";
    }
}
