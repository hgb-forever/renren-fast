package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.dao.ArticleDao;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 甘正
 * @Date: 2020/10/15  16:52
 * @Version 1.0
 */
@Service("ArticleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {
    @Override
    public Integer insertArticle(ArticleEntity articleEntity) {
        int code = baseMapper.insert(articleEntity);
        System.out.println(articleEntity);
        return code;
    }

    @Override
    public ArticleEntity selectArticleById(Long artId) {
        return baseMapper.selectOne(new QueryWrapper<ArticleEntity>().eq("article_id",artId ));
    }

    @Override
    public List<ArticleEntity> selectArticleByName(String keyword) {
        if (StringUtils.isBlank(keyword))
            return baseMapper.selectList(new QueryWrapper<ArticleEntity>());
        return baseMapper.selectList(new QueryWrapper<ArticleEntity>().like("article_title",keyword));
    }

    @Override
    public List<ArticleEntity> getAllArticle() {
        return baseMapper.selectList(new QueryWrapper<ArticleEntity>());
    }

    @Override
    public Integer delArticle(Long artId) {
        return baseMapper.deleteById(artId);
    }

    @Override
    public Integer updateArticle(ArticleEntity articleEntity) {
        return baseMapper.updateById(articleEntity);
    }


}
