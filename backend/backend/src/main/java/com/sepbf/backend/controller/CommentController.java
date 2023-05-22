package com.sepbf.backend.controller;/*
 author:@Antidote
 date:2023/5/2219:26
 
*/

import com.sepbf.backend.pojo.Comment;
import com.sepbf.backend.pojo.User;
import com.sepbf.backend.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.*;
import java.sql.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/getComment")
    public List<Map<String,Object>> getComment(@RequestBody Map<String, Object> map) {
        int news_id=(int)map.get("news_id");

        List<Comment> commentList=commentService.getComment(news_id);
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Comment comment: commentList){
            Map<String, Object> commentMap = new HashMap<>();
            commentMap.put("time",comment.getTime());
            commentMap.put("text",comment.getText());
            resultList.add(commentMap);
        }
        return resultList;
    }

    @PostMapping("/addComment")
    public boolean addComment(@RequestBody Map<String,Object> map){
        try {
        String text =(String) map.get("text");
        int news_id=(int)map.get("news_id");
        int user_id=(int)map.get("user_id");
        Date date=(Date)map.get("time");

        Comment new_comment= new Comment(news_id,user_id,date,text);
        return true;} catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }




}
