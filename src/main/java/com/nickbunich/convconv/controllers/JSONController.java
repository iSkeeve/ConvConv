package com.nickbunich.convconv.controllers;

import com.nickbunich.convconv.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Nick Bunich
 * Date: 2/3/14
 * Time: 2:32 AM
 */
@Controller
@RequestMapping("/getJson")
public class JSONController {

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody Song getSongInJSON(@PathVariable String name) {

        Song song = new Song();
        song.setName(name);
        song.setArtist("Unknown Artist");

        return song;

    }

}