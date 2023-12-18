package com.webtech.webtechProject.controllers;

import com.webtech.webtechProject.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("car", new User());
        return "redirect:/login";
    }

    @GetMapping("/trainerdash")
    public String showTrainerLandingPage(Model model) {
        model.addAttribute("trainerdash", new User());
        return "trainerdash";
    }

    @GetMapping("/userDash")
    public String showUserLandingPage(Model model) {
        model.addAttribute("userDash", new User());
        return "userDash";
    }

//    @PostMapping("/login")
//    public String handleLoginForm(Authentication authentication) {
//        User loggedInUser = (User) authentication.getPrincipal();
//        String userRole = loggedInUser.getRole();
//
//        if(userRole.equals("ROLE_TRAINEE")) {
//            return "redirect:/trainerdash";
//        } else if (userRole.equals("ROLE_TRAINER")) {
//            return "redirect:/userDash";
//        } else {
//            return "redirect:/login";
//        }
//    }


}
