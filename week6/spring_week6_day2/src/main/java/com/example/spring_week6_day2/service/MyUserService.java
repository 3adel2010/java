package com.example.spring_week6_day2.service;

import com.example.spring_week6_day2.model.MyUser;
import com.example.spring_week6_day2.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyUserService
{
    private final MyUserRepository myUserRepository;

    public void register(MyUser myUser)
    {
//        myUser.setUsername("USER");
        String hashedTitle = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedTitle);
        myUserRepository.save(myUser);
    }
    public boolean updateMyUser(Integer id,MyUser myUser)
    {
        MyUser myUser1 = myUserRepository.findMyUserById(id);
        if(myUser==null)
            return false;
        myUser.setId(id);
        myUserRepository.save(myUser);
        return true;
    }
    public boolean deleteMyUser(Integer id)
    {
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser==null)
            return false;
        myUserRepository.delete(myUser);
        return true;
    }
}
