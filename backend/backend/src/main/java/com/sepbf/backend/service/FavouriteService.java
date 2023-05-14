package com.sepbf.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.backend.pojo.Favourite;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:15
 */
public interface FavouriteService extends IService<Favourite> {

    boolean addFavourite(Favourite favourite);

    boolean deleteFavourite(Favourite favourite);

    Favourite getFavouriteById(Integer id);

    boolean updateFavourite(Favourite favourite);

}
