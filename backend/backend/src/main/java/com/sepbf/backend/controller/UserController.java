package com.sepbf.backend.controller;

import com.sepbf.backend.pojo.News;
import com.sepbf.backend.pojo.User;
import com.sepbf.backend.service.FavouriteService;
import com.sepbf.backend.service.NewsService;
import com.sepbf.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private NewsService newsService;

    @Resource
    private FavouriteService favouriteService;


    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map) {
        String phone_num = String.valueOf(map.get("phone_num"));
        String password = (String) map.get("password");

        User user = userService.getUserByPhone(phone_num);

        //如果用户存在且密码正确
        if (user != null && user.getPassword().equals(password)) {
            // 返回用户ID
            return String.valueOf(user.getUser_id());

        } else {
            return "false";
        }
    }


    @PostMapping("/register")
    public boolean register(@RequestBody Map<String, Object> map) {
        String phone_num = String.valueOf(map.get("phone_num"));
        String password = (String) map.get("password");

        String phone_num_str = String.valueOf(phone_num); // 转换为字符串

        User user = userService.getUserByPhone(phone_num_str);
        if (user != null) {
            return false; // 用户已存在
        } else {
            // 自动生成独一无二的ID
            int uniqueId = generateUniqueId();
            if (uniqueId < 0) {
                uniqueId = -uniqueId;
            }
            User newUser = new User(uniqueId, phone_num_str, password);
            userService.addUser(newUser);
            return true; // 注册成功
        }
    }


    // 生成唯一ID
    private int generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
    }

    @PostMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(@RequestBody Map<String, Object> requestBody) {
        int userId = (int) requestBody.get("user_id");
        // 根据用户ID查询用户信息
        User user = userService.getUserById(userId);
        System.out.println(user);

        // 根据用户ID查询用户收藏的新闻
        List<News> favoriteNewsList = newsService.getFavoriteNewsByUserId(userId);

        // 构建返回的结果Map
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("user_id", user.getUser_id());
        resultMap.put("phone_number", user.getPhone_number());

        List<Map<String, Object>> favoriteList = new ArrayList<>();
        for (News news : favoriteNewsList) {
            Map<String, Object> newsMap = new HashMap<>();
            newsMap.put("news_id", news.getNews_id());
            newsMap.put("title", news.getTitle());
            favoriteList.add(newsMap);
        }
        resultMap.put("favourites", favoriteList);

        return resultMap;
    }

    @PostMapping("/islike")
    public boolean isLike(@RequestBody Map<String, Object> requestBody) {
        int userId = (int) requestBody.get("user_id");
        int newsId = (int) requestBody.get("news_id");
        // 判断用户是否收藏了该新闻
        boolean isLike = favouriteService.isLike(userId, newsId);
        return isLike;
    }


}
