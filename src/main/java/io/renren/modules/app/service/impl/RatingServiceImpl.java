package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.dao.RatingDao;
import io.renren.modules.app.entity.RatingEntity;
import io.renren.modules.app.service.RatingService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/11/6  19:37
 * @Version 1.0
 */
@Service("RatingService")
public class RatingServiceImpl extends ServiceImpl<RatingDao, RatingEntity> implements RatingService {
    @Override
    public Integer insertRating(RatingEntity rating) {
        return baseMapper.insert(rating);
    }

    @Override
    public Integer delRatingById(Long titleId, Long userId) {
        HashMap map = new HashMap<>();
        map.put("title_id",titleId);
        map.put("user_id",userId);
        return baseMapper.deleteByMap(map);
    }

    @Override
    public RatingEntity selectRatingById(Long titleId, Long userId) {
        HashMap<String, Long> map = new HashMap<>();
        map.put("title_id",titleId);
        map.put("user_id",userId);
        return baseMapper.selectOne(new QueryWrapper<RatingEntity>().allEq(map));
    }


    @Override
    public List<RatingEntity> getAllRating() {
        return baseMapper.selectList(new QueryWrapper<RatingEntity>());
    }
}
