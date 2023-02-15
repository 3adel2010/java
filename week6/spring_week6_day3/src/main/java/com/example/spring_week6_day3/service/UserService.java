package com.example.spring_week6_day3.service;

import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public void register(User user)
    {
        String hashedTitle = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedTitle);
        userRepository.save(user);
    }
    public List<User> getUser()
    {
        return userRepository.findAll();
    }
    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user)
    {
        User user1 = userRepository.findUsersById(id);
        if(user1==null)
            return false;
        user.setId(id);
        userRepository.save(user);
        return true;
    }
    public boolean deleteUser(Integer id)
    {
        User user = userRepository.findUsersById(id);
        if(user==null)
            return false;
        userRepository.delete(user);
        return true;
    }
}
