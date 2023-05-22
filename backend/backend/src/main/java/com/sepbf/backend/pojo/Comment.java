package com.sepbf.backend.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("comment")
@Data
public class Comment {

    @TableId(type = IdType.AUTO)
    private int comment_id;

    private int news_id;

    private int user_id;

    private Date time;

    private String text;

    //构造函数
    public Comment(int comment_id, int news_id, int user_id, Date time, String text) {
        this.comment_id = comment_id;
        this.news_id = news_id;
        this.user_id = user_id;
        this.time = time;
        this.text = text;
    }

    public Comment(int news_id, int user_id, Date time, String text) {
        this.news_id = news_id;
        this.user_id = user_id;
        this.time = time;
        this.text = text;
    }


}
