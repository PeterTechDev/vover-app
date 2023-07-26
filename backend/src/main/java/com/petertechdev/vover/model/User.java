package com.petertechdev.vover.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {

    @Id
    private String id;
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(max = 20, message = "O nome não pode ter mais que 20 caracteres.")
    private String name;
    @Email(message = "E-mail inválido.")
    @NotBlank(message = "O e-mail não pode estar em branco.")
    @Size(max = 40, message = "O e-mail não pode ter mais que 40 caracteres.")
    private String email;
    private String profilePic;
    private List<Media> ReceivedMediaRecommendations;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
