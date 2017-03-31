package com.example.daniel.article.di;

import com.example.daniel.article.MainActivity;

import dagger.Component;

/**
 * Created by Daniel on 2017-03-31.
 */
@PerActivityScope
@Component(modules = ArticleModule.class, dependencies = ApplicationComponent.class)
public interface ArticleComponent {

    void inject(MainActivity activity);
}
