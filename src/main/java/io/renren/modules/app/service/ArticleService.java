package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.app.entity.ArticleEntity;

import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/10/15  15:40
 * @Version 1.0
 */

public interface ArticleService extends IService<ArticleEntity> {
    /**
     * 添加文章
     * @param articleEntity
     * @return
     */
    Integer insertArticle(ArticleEntity articleEntity);

    /**
     * 根据id查找文章
     * @param artId
     * @return
     */
    ArticleEntity selectArticleById(Long artId);

    /**
     * 根据关键字模糊查找
     * @param keyword
     * @return
     */
    List<ArticleEntity>  selectArticleByName(String keyword);

    /**
     * 获取所有文章
     * @return
     */
    List<ArticleEntity> getAllArticle();

    /**
     * 删除文章
     * @param artId
     * @return
     */
    Integer delArticle(Long artId);

    /**
     * 更新文章
     * @param articleEntity
     * @return
     */
    Integer updateArticle(ArticleEntity articleEntity);

}
