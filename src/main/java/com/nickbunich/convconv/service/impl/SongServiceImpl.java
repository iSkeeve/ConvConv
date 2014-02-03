package com.nickbunich.convconv.service.impl;

import com.nickbunich.convconv.model.Song;
import com.nickbunich.convconv.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * User: Nick Bunich
 * Date: 2/3/14
 * Time: 8:40 PM
 */

@Service
public class SongServiceImpl implements SongService {

    @Qualifier
    MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "song".intern();

    @Override
    public void addSong(Song song) {
        if (!mongoTemplate.collectionExists(Song.class)) {
            mongoTemplate.createCollection(Song.class);
        }
        song.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(song, COLLECTION_NAME);
    }

    @Override
    public List<Song> listSong() {
        return mongoTemplate.findAll(Song.class, COLLECTION_NAME);
    }

    @Override
    public List<Song> findSongs(String title) {
        return mongoTemplate.find(new Query(Criteria.where("title").is(title)), Song.class, COLLECTION_NAME);
    }

    @Override
    public void deleteSong(Song song) {
        mongoTemplate.remove(song, COLLECTION_NAME);
    }

    @Override
    public void updateSong(Song song) {
        mongoTemplate.insert(song, COLLECTION_NAME);
    }
}
