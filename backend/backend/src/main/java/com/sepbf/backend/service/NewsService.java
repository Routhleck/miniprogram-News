package com.sepbf.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.backend.pojo.News;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:15
 */
public interface NewsService extends IService<News> {

        boolean addNews(News news);

        boolean deleteNews(News news);

        boolean updateNews(News news);

        boolean deleteFavouritenum(int new_id);

        boolean addFavouritenum(int new_id);

        News getNewsById(Integer id);

        List<News> getAllNews();

        List<News> getFavoriteNewsByUserId(int userId);
}
