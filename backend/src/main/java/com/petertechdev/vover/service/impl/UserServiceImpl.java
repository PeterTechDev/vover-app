package com.petertechdev.vover.service.impl;

import com.petertechdev.vover.model.User;
import com.petertechdev.vover.repository.UserRepository;
import com.petertechdev.vover.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
            return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsersByName(String name) {
        List<User> allUsers = userRepository.findAll();

        List<User> usersFound = allUsers.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        return usersFound;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }
}
