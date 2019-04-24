package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.MyUserPrincipal;
import com.norofff.team1.footballapi.model.Users;
import com.norofff.team1.footballapi.repository.Users_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private User_Service userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Users> user = userService.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException(username+"does not exist"));
        return user.map(MyUserPrincipal::new).get();
    }

}
