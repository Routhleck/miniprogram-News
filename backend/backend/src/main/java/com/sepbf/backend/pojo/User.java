package com.sepbf.backend.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@TableName("user")
@Data
public class User {

    //用户id自增
    @TableId
    private int user_id;

    private String phone_number;

    private String password;

    //构造函数
    public User(int user_id, String phone_number, String password) {
        this.user_id = user_id;
        this.phone_number = phone_number;
        this.password = password;
    }

}
