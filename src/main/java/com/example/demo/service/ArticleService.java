package com.example.demo.service;
import com.example.demo.entity.Article;
import java.util.Collection;

public interface ArticleService {
    //获取文章名字
    Article getArticleByArticle(String article);
    //获取全部文章
    Collection<Article> getAllA();
    //保存文章
    void saveA(Article article);
    //更新文章
    void updateA(Article article);

    Article getA(String id);

    void delete(String articleId);
}
