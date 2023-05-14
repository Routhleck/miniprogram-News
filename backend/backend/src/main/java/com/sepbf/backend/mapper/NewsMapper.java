package com.sepbf.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.backend.pojo.News;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/5/14 16:17
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
