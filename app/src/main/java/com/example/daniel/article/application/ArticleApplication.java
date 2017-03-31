package com.example.daniel.article.application;

import android.app.Application;

import com.example.daniel.article.di.ApplicationComponent;
import com.example.daniel.article.di.ApplicationModule;
import com.example.daniel.article.di.DaggerApplicationComponent;


/**
 * Created by Daniel on 2017-03-31.
 */

public class ArticleApplication extends Application{
    // This that require a life cycle of the entire app
    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate(){
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://newsapi.org/v1/"))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return this.applicationComponent;
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
