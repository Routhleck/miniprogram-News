package com.sepbf.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.backend.pojo.Comment;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:15
 */
public interface CommentService extends IService<Comment> {

    boolean addComment(Comment comment);

    boolean deleteComment(Comment comment);

    boolean updateComment(Comment comment);

    Comment getCommentById(Integer id);

}
