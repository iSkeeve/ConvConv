package com.nickbunich.convconv.controllers;

import com.nickbunich.convconv.model.Song;
import com.nickbunich.convconv.service.SongService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Nick Bunich
 * Date: 2/3/14
 * Time: 2:32 AM
 */
@Controller
@RequestMapping("/getJson")
public class JSONController {

    @Autowired
    SongService songService;

    @RequestMapping(value = "{title}", method = RequestMethod.GET)
    public @ResponseBody
    List<Song> getSongInJSON(@PathVariable String title) {

        return songService.findSongs(title);
    }

}