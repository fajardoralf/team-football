package com.norofff.team1.footballapi.model;

import com.norofff.team1.footballapi.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MyUserPrincipal extends Users implements UserDetails {

    public MyUserPrincipal(final Users user){
        super(user);
    }
    public MyUserPrincipal(String username, String password){
        super(username,password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //TODO: if below code does not work, change role to be a string in user model and varchar in database
        /*
        getRole() = return role string from users model
        getRole()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());*/

        List<SimpleGrantedAuthority> ls = new ArrayList<>();
        if(isRole()){
            ls.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else{
            ls.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return ls;
    }

    @Override
    public String getPassword(){
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
