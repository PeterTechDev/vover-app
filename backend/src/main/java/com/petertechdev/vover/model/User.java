package com.petertechdev.vover.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String profilePic;
    private List<Media> ReceivedMediaRecommendations;
}
