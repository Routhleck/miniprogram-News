package com.sepbf.backend.controller;

import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {

    @Resource
    private FavouriteService favouriteService;

    @PostMapping("/addFavourite")
    public boolean addFavourite(@RequestBody Favourite favourite) {
        // 将新闻ID和用户ID添加到favourite表中
        favouriteService.addFavourite(favourite);

        return true;
    }
}
