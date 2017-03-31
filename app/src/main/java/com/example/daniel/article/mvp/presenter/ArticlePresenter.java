package com.example.daniel.article.mvp.presenter;

import com.example.daniel.article.api.ArticleApiService;
import com.example.daniel.article.base.BasePresenter;
import com.example.daniel.article.mapper.ArticleMapper;
import com.example.daniel.article.mvp.model.Article;
import com.example.daniel.article.mvp.model.ArticleResponse;
import com.example.daniel.article.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Daniel on 2017-03-31.
 */

public class ArticlePresenter extends BasePresenter<MainView> implements Observer<ArticleResponse>{

    @Inject protected ArticleApiService apiService;
    @Inject protected ArticleMapper articleMapper;

    @Inject
    public ArticlePresenter(){

    }
    public void getArticles() {
        getView().onShowDialog("Loading Articles...");
        Observable<ArticleResponse> articlesResponse = apiService.getArticles("techcrunch");
        subscribe(articlesResponse, this);

    }


    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading articles.. " + e.getMessage());
    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
        getView().onShowToast("Articles loaded");
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ArticleResponse articleResponse) {
        List<Article> articleList = articleMapper.mapArticle(articleResponse);
        getView().onArticleLoaded(articleList);

    }
}
