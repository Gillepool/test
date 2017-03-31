package com.example.daniel.article.api;

import com.example.daniel.article.mvp.model.ArticleResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel on 2017-03-31.
 */

public interface ArticleApiService {

    String BASE_URL = "https://newsapi.org/v1/";
    /*
    @GET("sources")
    Observable<SourceResponse> getSources();
    */
    @GET("articles?apikey=6380f04ef9944980a78319db6f1a590f")
    Observable<ArticleResponse> getArticles(@Query("source") String source);
}
