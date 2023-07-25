package com.petertechdev.vover.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "medias")
@Data
public class Media {

    public enum MediaType {
        MOVIE,
        SERIES,
        YOUTUBE_VIDEO,
        ANIME,
        TED_TALK,
    }

    public enum Platform {
        NETFLIX,
        AMAZON_PRIME,
        STARPLUS,
        YOUTUBE,
        DISNEY_PLUS,
        HBO_MAX,
        GLOBOPLAY,
        PARAMOUNT_PLUS,
        APPLE_TV,
        CRUNCHYROLL,

    }

    public enum Status {
        WATCHED,
        WATCHING,
        NOT_WATCHED
    }

    @Id
    private String id;
    private String title;
    private String description;
    private MediaType mediaType;
    private Platform platform;
    private Date dateOfRecommendation;
    private Integer seasons;
    private Integer episodes;
    private Status status = Status.NOT_WATCHED; // Default value

}

