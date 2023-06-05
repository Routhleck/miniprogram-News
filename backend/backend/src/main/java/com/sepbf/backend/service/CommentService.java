package com.sepbf.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.backend.pojo.Comment;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:15
 */
public interface CommentService extends IService<Comment> {

    boolean addComment(Comment comment);

    boolean deleteComment(int id);

    boolean updateComment(Comment comment);

    List<Comment> getComment(int id);
}
