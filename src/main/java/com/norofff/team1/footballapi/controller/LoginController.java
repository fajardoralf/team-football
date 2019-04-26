package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MyUserPrincipal;
import com.norofff.team1.footballapi.service.MyUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("rest/test")
public class LoginController {

    private MyUserDetailsService myUserDetailsService;

    @GetMapping
    public String login(@AuthenticationPrincipal MyUserPrincipal user){

        System.out.println("i was here");
        //UserDetails m = myUserDetailsService.loadUserByUsername("encoded");
        System.out.println("PRINT MEEEEEE ");
        System.out.println("--------------------------------");
        //String  username = m.getUsername();
        //Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        //authorities.forEach(System.out::println);
        return "ok";
    }
}
