package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.NewsMapper;
import com.sepbf.backend.pojo.News;
import com.sepbf.backend.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:22
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Resource
    NewsMapper newsMapper;

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
    public News getNewsById(Integer id) {
        return newsMapper.selectById(id);
    }


}
