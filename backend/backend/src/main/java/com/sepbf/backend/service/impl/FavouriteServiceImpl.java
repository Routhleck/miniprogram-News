package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.CommentMapper;
import com.sepbf.backend.mapper.FavouriteMapper;
import com.sepbf.backend.pojo.Comment;
import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.service.CommentService;
import com.sepbf.backend.service.FavouriteService;
import com.sepbf.backend.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:21
 */
@Service("favouriteService")
public class FavouriteServiceImpl extends ServiceImpl<FavouriteMapper, Favourite> implements FavouriteService {

    @Resource
    FavouriteMapper favouriteMapper;

    @Resource
    NewsService newsService;

    @Override
    public boolean addFavourite(int news_id, int user_id) {
        newsService.addFavouritenum(news_id);
        Favourite favourite = new Favourite(news_id,user_id);
        int result = favouriteMapper.insert(favourite);
        return result == 0;
    }

    @Override
    public boolean deleteFavourite(int news_id, int user_id) {
        newsService.deleteFavouritenum(news_id);
        boolean result = favouriteMapper.deleteFavourite(user_id, news_id);
        return result;
    }

    @Override
    public Favourite selectFavourite(int news_id, int user_id) {
        return favouriteMapper.selectFavourite(user_id,news_id);
    }

    @Override
    public boolean updateFavourite(Favourite favourite) {
        int result = favouriteMapper.updateById(favourite);
        return result == 0;
    }

    @Override
    public Favourite getFavouriteById(Integer id) {
        return favouriteMapper.selectById(id);
    }

    @Override
    public boolean isLike(int news_id,int user_id){
        Favourite favourite = favouriteMapper.selectFavourite(news_id,user_id);
        return favourite != null;
    }



}
