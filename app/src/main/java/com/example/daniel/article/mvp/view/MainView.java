package com.example.daniel.article.mvp.view;

import com.example.daniel.article.mvp.model.Article;

import java.util.List;

/**
 * Created by Daniel on 2017-03-31.
 */

public interface MainView extends BaseView {
    void onArticleLoaded(List<Article> articleList);

    void onShowToast(String s);

    void onShowDialog(String s);

    void onHideDialog();
}
