package com.company.service;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableResourceServer
public class ApplicationController {

    @GetMapping("/")
    public String showIndexPage(Model model,
                                Principal principal) {

        model.addAttribute("user",
                           principal.getName());

        return "index";
    }
}
