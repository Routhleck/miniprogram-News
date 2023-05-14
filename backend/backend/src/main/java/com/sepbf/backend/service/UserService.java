package com.sepbf.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.backend.pojo.User;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:15
 */
public interface UserService extends IService<User> {

    boolean addUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    User getUserById(Integer id);

}
