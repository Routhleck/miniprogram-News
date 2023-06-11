package com.sepbf.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.backend.pojo.Favourite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:17
 */
@Mapper
public interface FavouriteMapper extends BaseMapper<Favourite> {

    @Select("SELECT news_id FROM favourite WHERE user_id = #{userId}")
    List<Integer> selectNewsIdByUserId(int userId);

    @Select("SELECT * FROM favourite WHERE user_id = #{userId} and news_id = #{newsId}")
    Favourite selectFavourite(int userId, int newsId);

    @Delete("DELETE FROM favourite WHERE user_id = #{userId} and news_id = #{newsId}")
    boolean deleteFavourite(int userId,int newsId);


}
