package com.sepbf.backend.controller;

import com.sepbf.backend.pojo.News;
import com.sepbf.backend.service.CommentService;
import com.sepbf.backend.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private CommentService commentService;
    @Resource
    private NewsService newsService;

    @GetMapping("/getAllNews")
    public List<Map<String, Object>> getAllNews() {
        List<News> newsList = newsService.getAllNews();

        List<Map<String, Object>> resultList = new ArrayList<>();
        for (News news : newsList) {
            Map<String, Object> newsMap = new HashMap<>();
            newsMap.put("news_id", news.getNews_id());
            newsMap.put("title", news.getTitle());
            resultList.add(newsMap);
        }

        return resultList;
    }

    @PostMapping("/getNewsById")
    public Map<String, Object> getNewsById(@RequestBody Map<String, Object> map) {
            int newsId = Integer.parseInt((String) map.get("news_id"));
            News news = newsService.getNewsById(newsId);

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("news_id", news.getNews_id());
            resultMap.put("title", news.getTitle());
            resultMap.put("author", news.getAuthor());
            resultMap.put("time", news.getTime());
            resultMap.put("text", news.getText());
            resultMap.put("favorite_num", news.getFavourite_num());

            return resultMap;
    }

    @PostMapping("/getNewsByIndexNumCategory")
    public List<Map<String, Object>> getNewsByIndexNumCategory(@RequestBody Map<String, Object> map) {
        int index = Integer.parseInt((String) map.get("index"));
        int num = Integer.parseInt((String) map.get("num"));
        String category = (String) map.get("category");

        // 判断index是否超过数组大小, 若超过则返回空
        int maxIndex = newsService.getNewsLenByCategory(category);
        if (index > maxIndex) {
            return null;
        }

        List<News> newsList = newsService.getNewsByIndexNumCategory(index, num, category);

        List<Map<String, Object>> resultList = new ArrayList<>();
        for (News news : newsList) {
            Map<String, Object> newsMap = new HashMap<>();
            newsMap.put("news_id", news.getNews_id());
            newsMap.put("title", news.getTitle());
            resultList.add(newsMap);
        }

        return resultList;

    }




}
