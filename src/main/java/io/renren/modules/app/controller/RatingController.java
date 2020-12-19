package io.renren.modules.app.controller;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.RatingEntity;
import io.renren.modules.app.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/11/6  19:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/rating")
@Api(value = "评分控制接口",tags = "评分控制接口")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    /*
    *     //    添加评分记录
    Integer insertRating(RatingEntity rating);
    //    删除评分记录
    Integer delRatingById(Long articleId,Long userId);
    //    根据id查找评分记录
    RatingEntity selectRatingById(Long articleId,Long userId);
    //    获取评分列表
    List<RatingEntity> getAllRating();
    * */
    @PostMapping("/insertRating")
    @ApiOperation("添加评分记录")
    public R insertRating(@RequestBody RatingEntity ratingEntity){
        ratingEntity.setTimeStamp(null);
        Date nowTime = new Date(System.currentTimeMillis());
        ratingEntity.setTimeStamp(nowTime);
        Integer integer = ratingService.insertRating(ratingEntity);
        System.out.println(integer);
        return R.ok().put("msg","插入成功");
    }

    @GetMapping("/delRatingById")
    @ApiOperation("删除评分记录")
    public R delRatingById(@RequestParam("articleId") Long articleId,@RequestParam("userId") Long userId){
        ratingService.delRatingById(articleId,userId);
        return R.ok().put("msg","删除成功");
    }

    @GetMapping("selectRatingById")
    @ApiOperation("根据id查找评分记录")
    public RatingEntity selectRatingById(@RequestParam("articleId") Long articleId,@RequestParam("userId") Long userId){
        RatingEntity ratingEntity = ratingService.selectRatingById(articleId, userId);
        return ratingEntity;
    }

    @GetMapping("/getAllRating")
    @ApiOperation("获取评分列表")
    public List<RatingEntity> getAllRating(){
        List<RatingEntity> allRating = ratingService.getAllRating();
        return allRating;
    }
}
