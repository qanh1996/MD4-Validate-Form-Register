package com.codegym.controller;

import com.codegym.model.Users;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    public IUserService userService;

    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("user",new Users());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") Users user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/user/index");
        }
        userService.save(user);
        Iterable<Users> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/user/result");
        modelAndView.addObject("users", users);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
