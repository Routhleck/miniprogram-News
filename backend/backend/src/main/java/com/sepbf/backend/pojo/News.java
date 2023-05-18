package com.sepbf.backend.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("news")
@Data
public class News {

    @TableId
    private int news_id;

    private String title;

    private String author;

    private Date time;

    private String text;

    private int favourite_num;

    //构造函数
    public News(int news_id, String title, String author, Date time, String text, int favourite_num) {
        this.news_id = news_id;
        this.title = title;
        this.author = author;
        this.time = time;
        this.text = text;
        this.favourite_num = favourite_num;
    }


}
