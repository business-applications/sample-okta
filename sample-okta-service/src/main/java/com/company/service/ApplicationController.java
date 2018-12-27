package com.company.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableResourceServer
public class ApplicationController {

    @GetMapping("/")
    public String showIndexPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String principal = (String) auth.getPrincipal();
        OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) auth.getDetails();

        model.addAttribute("authenticated",
                           auth.isAuthenticated());
        model.addAttribute("authdetails",
                           authDetails);
        model.addAttribute("user",
                           principal);

        return "index";
    }
}
