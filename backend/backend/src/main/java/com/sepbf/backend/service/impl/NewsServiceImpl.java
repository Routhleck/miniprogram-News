package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.FavouriteMapper;
import com.sepbf.backend.mapper.NewsMapper;
import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.pojo.News;
import com.sepbf.backend.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:22
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Resource
    NewsMapper newsMapper;

    @Resource
    FavouriteMapper favouriteMapper;

    @Override
    public boolean addNews(News news) {
        int result = newsMapper.insert(news);
        return result == 0;
    }

    @Override
    public boolean deleteNews(News news) {
        int result = newsMapper.delete(news);
        return result == 0;
    }

    @Override
    public boolean updateNews(News news) {
        int result = newsMapper.updateById(news);
        return result == 0;
    }

    @Override
    public boolean deleteFavouritenum(int new_id) {
        newsMapper.deleteFavourite(new_id);
        return true;
    }

    @Override
    public boolean addFavouritenum(int new_id) {
        newsMapper.addFavourite(new_id);
        return true;
    }

    @Override
    public News getNewsById(Integer id) {
        return newsMapper.selectById(id);
    }

    @Override
    public List<News> getAllNews() {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        return newsMapper.selectList(queryWrapper);
    }

    @Override
    public List<News> getFavoriteNewsByUserId(int userId) {
        // 根据用户ID查询用户收藏的新闻的ID
        List<Integer> newsIdList = favouriteMapper.selectNewsIdByUserId(userId);
        // 根据新闻ID查询新闻
        List<News> newsList = new ArrayList<>();
        for (Integer newsId : newsIdList) {
            newsList.add(newsMapper.selectById(newsId));
        }
        return newsList;
    }



}
