package com.nickbunich.convconv.service;

import com.nickbunich.convconv.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * User: Nick Bunich
 * Date: 2/3/14
 * Time: 8:33 PM
 */

public interface SongService {

    void addSong(Song song);

    List<Song> listSong();

    void deleteSong(Song song);

    public void updateSong(Song song);

    List<Song> findSongs(String title);
}
