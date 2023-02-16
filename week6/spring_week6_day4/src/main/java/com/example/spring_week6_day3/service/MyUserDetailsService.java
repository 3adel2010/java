package com.example.spring_week6_day3.service;

import com.example.spring_week6_day3.apiException.ApiException;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findUsersByUsername(username);
        if(user==null)
            throw new ApiException("Username is wrong !");
        return user;
    }
}
