package com.sepbf.backend.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {

    private int user_id;

    private int phone_number;

    private String password;

    //构造函数
    public User(int user_id, int phone_number, String password) {
        this.user_id = user_id;
        this.phone_number = phone_number;
        this.password = password;
    }
}
