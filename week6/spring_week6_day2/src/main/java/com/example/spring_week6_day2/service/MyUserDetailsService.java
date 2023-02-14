package com.example.spring_week6_day2.service;

import com.example.spring_week6_day2.model.MyUser;
import com.example.spring_week6_day2.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService
{
    private final MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        MyUser myUser =myUserRepository.findMyUserByUsername(username);
        if(myUser==null)
            throw new UsernameNotFoundException("Username is wrong !");
        return myUser;
    }
}
