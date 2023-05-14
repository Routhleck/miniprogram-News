package com.sepbf.backend.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("favourite")
@Data
public class Favourite {

    private int favourite_id;

    private int news_id;

    private int user_id;

    //构造函数
    public Favourite(int favourite_id, int news_id, int user_id) {
        this.favourite_id = favourite_id;
        this.news_id = news_id;
        this.user_id = user_id;
    }

}
