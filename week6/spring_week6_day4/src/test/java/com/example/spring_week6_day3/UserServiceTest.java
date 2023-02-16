package com.example.spring_week6_day3;

import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.UserRepository;
import com.example.spring_week6_day3.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest
{
    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    User user1,user2,user3;
    List<User> userList;
    @BeforeEach
    void setUpTest()
    {
        user1 = new User(null,"adel","123456","Admin",null);
        user2 = new User(null,"adel","123456","Admin",null);
        user3 = new User(null,"adel","123456","Admin",null);
        userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    @Test
    public void registerTest()
    {
        userRepository.save(user1);
        String hashedTitle = new BCryptPasswordEncoder().encode(user1.getPassword());
        user1.setPassword(hashedTitle);
        verify(userRepository,times(1)).save(user1);
    }
    @Test
    public void getUserTest()
    {
        when(userRepository.findAll()).thenReturn(userList);
        List<User> list= userRepository.findAll();
        Assertions.assertEquals(3,list.size());
        verify(userRepository,times(1)).findAll();
    }
    @Test
    public void addUserTest()
    {
        userService.addUser(user1);
        verify(userRepository, times(1)).save(user1);
    }
    @Test
    public void updateUserTest()
    {
        when(userRepository.findUsersById(user1.getId())).thenReturn(user1);
        userService.updateUser(user1.getId(),user1);
        verify(userRepository, times(1)).findUsersById(user1.getId());
        verify(userRepository, times(1)).save(user1);
    }
    @Test
    public void deleteUser()
    {
        when(userRepository.findUsersById(user1.getId())).thenReturn(user1);
        userService.deleteUser(user1.getId());
        verify(userRepository, times(1)).findUsersById(user1.getId());
        verify(userRepository, times(1)).delete(user1);
    }
}
