package com.sepbf.backend.controller;

import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.service.FavouriteService;
import com.sepbf.backend.service.NewsService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {

    @Resource
    private FavouriteService favouriteService;
    @Resource
    private NewsService newsService;

    @PostMapping("/addFavourite")
    public boolean addFavourite(@RequestBody Map<String, Object> map) {
        int news_id= Integer.parseInt((String) map.get("news_id"));
        int user_id= Integer.parseInt((String) map.get("user_id"));

        Favourite favourite=favouriteService.selectFavourite(news_id,user_id);
        System.out.println(favourite);

        if (favourite==null){
            favouriteService.addFavourite(news_id,user_id);
            return true;
        }
        else {
            return false;
        }

    }

    @PostMapping("/deleteFavourite")
    public boolean deleteFavourite(@RequestBody Map<String, Object> map) {
        int news_id = Integer.parseInt((String) map.get("news_id"));
        int user_id = Integer.parseInt((String) map.get("user_id"));

        favouriteService.deleteFavourite(news_id, user_id);
        return true;
    }
}
