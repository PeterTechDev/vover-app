package com.petertechdev.vover.repositories;

import com.petertechdev.vover.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRespository extends MongoRepository<User, String> {
}
