package com.example.daniel.article.di;

import com.example.daniel.article.api.ArticleApiService;
import com.example.daniel.article.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Daniel on 2017-03-31.
 */
@Module
public class ArticleModule {


    private MainView view;
    public ArticleModule(MainView view){
        this.view = view;
    }

    @PerActivityScope
    @Provides
    ArticleApiService provideArticleApiService(Retrofit retrofit){
        return retrofit.create(ArticleApiService.class);
    }

    @PerActivityScope
    @Provides
    MainView provideMainView(){
        return this.view;
    }
}
