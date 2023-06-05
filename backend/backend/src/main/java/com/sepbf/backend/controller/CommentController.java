package com.sepbf.backend.controller;/*
 author:@Antidote
 date:2023/5/2219:26

*/

import com.sepbf.backend.pojo.Comment;
import com.sepbf.backend.pojo.User;
import java.time.LocalDate;
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
        int news_id= Integer.parseInt((String) map.get("news_id"));

        System.out.println(news_id+"have been received");

        List<Comment> commentList=commentService.getComment(news_id);
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Comment comment: commentList){
            Map<String, Object> commentMap = new HashMap<>();
            commentMap.put("comment_id",comment.getComment_id());
            commentMap.put("user_id",comment.getUser_id());
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

        String timeStr = (String) map.get("time");
        LocalDate localDate = LocalDate.parse(timeStr);
        Date date = Date.valueOf(localDate);


            Comment new_comment= new Comment(news_id,user_id,date,text);
        commentService.addComment(new_comment);

        return true;} catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @PostMapping("/deleteComment")
    public boolean deleteComment(@RequestBody Map<String,Object> map){
        try {
            int comment_id= Integer.parseInt((String) map.get("comment_id"));
            commentService.deleteComment(comment_id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
