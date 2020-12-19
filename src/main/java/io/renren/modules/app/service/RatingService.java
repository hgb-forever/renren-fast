package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.app.entity.RatingEntity;

import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/11/6  19:35
 * @Version 1.0
 */
public interface RatingService extends IService<RatingEntity> {
    //    添加评分记录
    Integer insertRating(RatingEntity rating);
    //    删除评分记录
    Integer delRatingById(Long titleId,Long userId);
    //    根据id查找评分记录
    RatingEntity selectRatingById(Long titleId,Long userId);
    //    获取评分列表
    List<RatingEntity> getAllRating();
}
