package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.RatingEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/11/6  19:30
 * @Version 1.0
 */
@Mapper
public interface RatingDao extends BaseMapper<RatingEntity> {

}
