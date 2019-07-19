package com.example.demo.service.impl;

import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article getArticleByArticle(String article) {
        return articleMapper.getArticleByArticle(article);
    }

    @Override
    public Collection<Article> getAllA() {
        return articleMapper.getAllA();
    }

    @Override
    public void saveA(Article article) {
        String navid = UUID.randomUUID().toString();
        article.setArticleId(navid);
        articleMapper.saveA(article);

    }

    @Override
    public void updateA(Article article) {

        articleMapper.updateA(article);

    }
    @Override
    public Article getA(String id) {

        return articleMapper.getArticleByArticle(id);
    }

    @Override
    public void delete(String articleId) {
        articleMapper.delete(articleId);
    }

}
