package com.sepbf.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int delete(User user);

    @Select("SELECT * FROM user WHERE phone_number = #{phoneNum}")
    User selectByPhone(String phoneNum);
}

