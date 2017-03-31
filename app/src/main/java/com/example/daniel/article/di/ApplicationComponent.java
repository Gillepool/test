package com.example.daniel.article.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Daniel on 2017-03-31.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    //void inject(ArticleApplication application)
    Retrofit exposeRetrofit();
    Context exposeContext();
}
