package com.petertechdev.vover.repository;

import com.petertechdev.vover.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'name': { $regex: ?0, $options: 'i' }}")
    List<User> findAllByName(String name);
}
