package com.example.spring_week4_day2_exc.servise;

import com.example.spring_week4_day2_exc.model.User;
import com.example.spring_week4_day2_exc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServise
{
    private final UserRepository userRepository;

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
        User users =userRepository.getById(id);

        if(users == null)
            return false;

        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Integer id)
    {
        User users = userRepository.getById(id);

        if(users == null)
            return false;

        userRepository.delete(users);
        return true;
    }
}
