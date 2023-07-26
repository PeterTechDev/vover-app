package com.petertechdev.vover.repositories;

import com.petertechdev.vover.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MediaRepository extends MongoRepository<Media, String> {

    @Query("{'title': { $regex: ?0, $options: 'i' }}")
    List<Media> findAllByTitle(String title);
}
