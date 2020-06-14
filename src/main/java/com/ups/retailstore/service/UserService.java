package com.ups.retailstore.service;

import com.ups.retailstore.entity.CustomUserDetails;
import com.ups.retailstore.entity.User;
import com.ups.retailstore.exceptionhandling.exceptions.ConflictException;
import com.ups.retailstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user == null)
            throw new BadCredentialsException("Bad credentials");

        CustomUserDetails userDetails = new CustomUserDetails(user);

        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }




    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    public void saveNewUser(User user) {


        if(userRepository.findByEmail(user.getEmail())!=null) {

            throw new ConflictException(String.format("The E-Mail [%s] already exist",user.getEmail()));
        }

        else {

            user.setPassword(passwordEncoder().encode(user.getPassword()));

            userRepository.save(user);

        }
    }

}
