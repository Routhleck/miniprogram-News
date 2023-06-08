package com.sepbf.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.backend.pojo.Favourite;
import com.sepbf.backend.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:17
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {
    int delete(News news);

    News selectById(Integer id);

    // 根据用户ID查询用户收藏的新闻
    @Select("SELECT n.news_id, n.title " +
            "FROM news n " +
            "INNER JOIN favourite f ON n.news_id = f.news_id " +
            "WHERE f.user_id = #{userId}")
    List<News> getFavoriteNewsByUserId(int userId);

    //
    @Update("UPDATE news SET favourite_num = favourite_num+1 WHERE news_id = #{news_id} ")
    boolean addFavourite(int news_id);

    @Update("UPDATE news SET favourite_num = favourite_num-1 WHERE news_id = #{news_id} ")
    boolean deleteFavourite(int news_id);


    @Select("SELECT * FROM news WHERE category=#{category}")
    List<News> selectByCategory(String category);
}
