package io.renren.modules.app.controller;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


/**
 * @Author: 甘正
 * @Date: 2020/10/15  16:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
@Api("文章控制接口")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    @ApiOperation(value = "添加文章")
    public R addArticle(@ApiParam(value = "articleEntity") @RequestBody ArticleEntity articleEntity){
        articleEntity.setCreateTime(null);
        articleEntity.setArticleId(0L);
        Date nowTime = new Date(System.currentTimeMillis());
        articleEntity.setCreateTime(nowTime);
        int save = articleService.insertArticle(articleEntity);
        return R.ok().put("msg","插入成功").put("ArticleEntity",articleEntity);
    }

    @GetMapping("/getArticleById/{artId}")
    @ApiOperation("查找文章")
    public R getArticleById(@ApiParam("文章id") @PathVariable("artId") Long artId){
        ArticleEntity articleEntity = articleService.selectArticleById(artId);
        System.out.println(artId);
//        System.out.println(articleEntity);
        return R.ok().put("ArticleEntity",articleEntity);
    }

    @GetMapping("/getArticleByName")
    @ApiOperation("查找文章")
    public List<ArticleEntity> getArticleByName(@ApiParam("文章标题")   @RequestParam(name = "keyword", required = false) String keyword){
        List<ArticleEntity> articleEntity = articleService.selectArticleByName(keyword);
        System.out.println(keyword);
//        System.out.println(articleEntity);
        return articleEntity;
    }

    @GetMapping("/getAllArticle")
    @ApiOperation("获取所有文章")
    public List<ArticleEntity> getAllArticle(){
        return  articleService.getAllArticle();
    }




    @GetMapping("/delArticle/{artid}")
    @ApiOperation("按文章id删除文章")
    public R delArticle(@PathVariable("artid") Long artid){
        Integer integer = articleService.delArticle(artid);
        return R.ok().put("msg","操作成功");
    }

    @PostMapping("/updateArticle")
    @ApiOperation("更新文章")
    public R updateArticle(@ApiParam(value = "articleEntity") @RequestBody ArticleEntity articleEntity){
        articleService.updateArticle(articleEntity);
        return R.ok().put("msg","更新文章成功");
    }
}
