package com.example.demo.mapper;

import com.example.demo.entity.Article;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface ArticleMapper {
    Article getArticleByArticle(String article);

    Collection<Article> getAllA();

    void saveA(Article article);

    void updateA(Article article);

    Article getA(String id);

    void delete(String articleId);
}