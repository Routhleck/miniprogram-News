package com.sepbf.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("favourite")
public class Favourite {

    @TableId(type = IdType.AUTO)
    private int favourite_id;

    private int news_id;

    private int user_id;

    // 构造函数
    public Favourite(int news_id, int user_id) {
        this.news_id = news_id;
        this.user_id = user_id;
    }

}
