package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class CommonController {

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model){
        log.info("access Denied: " + auth);// 인증
        // org.springframework.security.authentication.UsernamePasswordAuthenticationToken@8fc7dd: Principal: org.springframework.security.core.userdetails.User@bfc28a9a: Username: member; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_MEMBER; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@0: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: C8A15D9E07F8054748C76AD095D6715E; Granted Authorities: ROLE_MEMBER

        model.addAttribute("msg", "Access Denied");
    }

    @GetMapping("/customLogin")
    public void loginInput(String error, String logout, Model model){
        log.info("error: " + error);
        log.info("logout: " + logout);

        if(error != null){
            model.addAttribute("error", "Login Error Check Your Account");
        }

        if(logout != null){
            model.addAttribute("logout", "Logout!!");
        }
    }

    @GetMapping("/customLogout")
    public void logoutGet(){
        log.info("custom logout");
    }
}
