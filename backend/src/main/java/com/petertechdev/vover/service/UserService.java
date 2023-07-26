package com.petertechdev.vover.service;


import com.petertechdev.vover.model.User;
import com.petertechdev.vover.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    List<User> getAllUsersByName(String name);

    User getUserById(String userId);
}
