package com.petertechdev.vover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import com.petertechdev.vover.model.User;
import com.petertechdev.vover.repository.UserRepository;
import com.petertechdev.vover.service.impl.UserServiceImpl;

public class UserServiceImplTest {

    private UserServiceImpl userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testGetAllUsersByName() {
        String nameToSearch = "James";

        User user1 = new User("Lebron James", "kingjames@nba.com");
        User user2 = new User("James Harden", "thebeard@nba.com");
        User user3 = new User("Michael Jordan", "michael@nba.com");

        List<User> allUsers = Arrays.asList(user1, user2, user3);

        when(userRepository.findAll()).thenReturn(allUsers);

        List<User> usersFound = userService.getAllUsersByName(nameToSearch);

        assertEquals(2, usersFound.size());
        assertEquals(user1, usersFound.get(0));
        assertEquals(user2, usersFound.get(1));

        verify(userRepository, times(1)).findAll();

        //JUST FOR DEBUG
        System.out.println("Number of users found: " + usersFound.size());
        for (User user : usersFound) {
            System.out.println("User name: " + user.getName());
        }
    }

    @Test
    public void testCreateUser() {
        User newUser = new User("Giannis Antetokounmpo", "greekfreak@nba.com");

        when(userRepository.save(newUser)).thenReturn(newUser);

        User createdUser = userService.createUser(newUser);

        assertEquals(newUser, createdUser);

        verify(userRepository, times(1)).save(newUser);
    }
}