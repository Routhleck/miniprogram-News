package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.UserMapper;
import com.sepbf.backend.pojo.User;
import com.sepbf.backend.service.UserService;

import javax.annotation.Resource;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:22
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        int result = userMapper.insert(user);
        return result == 0;
    }

    @Override
    public boolean deleteUser(User user) {
        int result = userMapper.delete(user);
        return result == 0;
    }

    @Override
    public boolean updateUser(User user) {
        int result = userMapper.updateById(user);
        return result == 0;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }


}
