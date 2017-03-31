package com.example.daniel.article.mapper;

import com.example.daniel.article.mvp.model.Article;
import com.example.daniel.article.mvp.model.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Daniel on 2017-03-31.
 */

public class ArticleMapper {

    @Inject
    public ArticleMapper(){

    }

    public List<Article> mapArticle(ArticleResponse response) {
        List<Article> articleList = new ArrayList<>();
        
        if(response != null) {
            List<Article> articles = response.getArticles();
            if(articles != null){
                for(Article article : articles){
                    Article a = new Article();
                    a.setTitle(article.getTitle());
                    a.setAuthor(article.getAuthor());
                    a.setDescription(article.getDescription());
                    a.setUrlToImage(article.getUrlToImage());
                    a.setUrl(article.getUrl());
                    a.setPublishedAt(article.getPublishedAt());
                    articleList.add(a);
                }
            }
        }
        return articleList;
    }
}
