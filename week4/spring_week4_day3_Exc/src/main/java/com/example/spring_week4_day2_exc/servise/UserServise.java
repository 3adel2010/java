package com.example.spring_week4_day2_exc.servise;

import com.example.spring_week4_day2_exc.Exception.ApiException;
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

    public User findUserByEmail(String email)
    {
        User user = userRepository.findUserByEmail(email);
        if (user == null)
        {
            throw new ApiException("Email is not found!");
        }
        return user;
    }

    public List<User> findUserByRole(String role)
    {
        List<User> user = userRepository.findUserByRole(role);
        if (user == null)
        {
            throw new ApiException("Role is not found!");
        }
        return user;
    }

    public List<User> findSpecificAge(Integer age)
    {
        List<User> user = userRepository.findSpecificAge(age);
        if (user == null)
        {
            throw new ApiException("Age is not found!");
        }
        if (user.isEmpty())
        {
            throw new ApiException("Age is not found!");
        }
        return user;
    }

    public void findUsernameAndPassword(User user){

        if (user.getUserName() == null || user.getPassword() == null)
            throw new ApiException("Username and password are required");

        User fetched = userRepository.findIdForMe(user.getUserName(), user.getPassword());

        if (fetched == null)
            throw new ApiException("Username and password are incorrect");
    }
}
