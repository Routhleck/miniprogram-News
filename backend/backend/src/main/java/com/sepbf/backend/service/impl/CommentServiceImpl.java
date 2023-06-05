package com.sepbf.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.backend.mapper.CommentMapper;
import com.sepbf.backend.pojo.Comment;
import com.sepbf.backend.pojo.News;
import com.sepbf.backend.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:21
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public boolean addComment(Comment comment) {
        int result = commentMapper.insert(comment);
        return result == 0;
    }

    @Override
    public boolean deleteComment(int id) {
        int result = commentMapper.deleteById(id);
        return result == 0;
    }

    @Override
    public boolean updateComment(Comment comment) {
        int result = commentMapper.updateById(comment);
        return result == 0;
    }

    @Override
    public List<Comment> getComment(int id) {
        return commentMapper.getCommentByNewsId(id);
    }



}
