package com.ups.retailstore.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails extends User implements UserDetails {


    public CustomUserDetails(User user) {

        super(user);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !super.isAccountNonExpired();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !super.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !super.isAccountNonLocked();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        super.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        });

        return authorities;
    }

    @Override
    public String getPassword() {

        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }





}
