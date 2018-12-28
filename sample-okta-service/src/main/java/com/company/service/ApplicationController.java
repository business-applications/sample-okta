package com.company.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
    @PreAuthorize("hasAuthority('Admin')")
    public String showAdminsPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        String principal = (String) auth.getPrincipal();
        String gaStr = "";
        for (GrantedAuthority ga : auth.getAuthorities()) {
            gaStr += ga.getAuthority() + " ";
        }

        model.addAttribute("authenticated",
                           auth.isAuthenticated());
        model.addAttribute("authdetails",
                           authDetails);
        model.addAttribute("user",
                           principal);
        model.addAttribute("ga",
                           gaStr);

        return "index";
    }

    @GetMapping("/sales")
    @PostAuthorize("hasAuthority('Sales')")
    public String showSalesPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String principal = (String) auth.getPrincipal();
        OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        String gaStr = "";
        for (GrantedAuthority ga : auth.getAuthorities()) {
            gaStr += ga.getAuthority() + " ";
        }

        model.addAttribute("authenticated",
                           auth.isAuthenticated());
        model.addAttribute("authdetails",
                           authDetails);
        model.addAttribute("user",
                           principal);
        model.addAttribute("ga",
                           gaStr);

        return "sales";
    }

    @GetMapping("/403")
    public String showAccessDenied() {
        return "errors/403";
    }
}
