package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.CommentMapper;
import com.sepbf.backend.mapper.FavouriteMapper;
import com.sepbf.backend.pojo.Comment;
import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.service.CommentService;
import com.sepbf.backend.service.FavouriteService;
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


    @Override
    public boolean addFavourite(Favourite favourite) {
        int result = favouriteMapper.insert(favourite);
        return result == 0;
    }

    @Override
    public boolean deleteFavourite(Favourite favourite) {
        int result = favouriteMapper.delete(favourite);
        return result == 0;
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



}
