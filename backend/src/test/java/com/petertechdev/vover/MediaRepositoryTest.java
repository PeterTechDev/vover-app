package com.petertechdev.vover;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.petertechdev.vover.model.Media;
import com.petertechdev.vover.repository.MediaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class MediaRepositoryTest {

    @Autowired
    private MediaRepository mediaRepository;

    @Test
    public void testFindByTitle() {

        // Quando buscamos a mídia pelo título "Zootopia"
        List<Media> foundMediaList = mediaRepository.findAllByTitle("Zootopia");

        assertFalse(foundMediaList.isEmpty());
        assertEquals("Zootopia", foundMediaList.get(0).getTitle());

        //JUST FOR DEBUG
        System.out.println("Number of Media found : " + foundMediaList.size());

        for (Media media : foundMediaList) {
            System.out.println("Media title  : " + media.getTitle());
        }
    }
}
