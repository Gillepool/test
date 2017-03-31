package com.example.daniel.article;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.daniel.article.Adapter.ArticleAdapter;
import com.example.daniel.article.base.BaseActivity;
import com.example.daniel.article.di.ArticleModule;
import com.example.daniel.article.di.DaggerArticleComponent;
import com.example.daniel.article.mvp.model.Article;
import com.example.daniel.article.mvp.presenter.ArticlePresenter;
import com.example.daniel.article.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements MainView{

    @BindView(R.id.activity_article_list_recycler_view) protected RecyclerView articleList;
    @Inject protected ArticlePresenter presenter;
    private ArticleAdapter articleAdapter;

    @Override
    public void onArticleLoaded(List<Article> articleList) {
        articleAdapter.addArticles(articleList);
    }

    @Override
    public void onShowToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowDialog(String s) {
        showDialog(s);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initList();
        this.presenter.getArticles();
    }

    private void initList() {
        articleList.setHasFixedSize(true);
        articleList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        articleAdapter = new ArticleAdapter(getLayoutInflater());
        articleList.setAdapter(articleAdapter);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerArticleComponent.builder()
                .applicationComponent(getApplicationComponent())
                .articleModule(new ArticleModule(this))
                .build()
                .inject(this);
    }
}
