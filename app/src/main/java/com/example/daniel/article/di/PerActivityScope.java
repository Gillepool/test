package com.example.daniel.article.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Daniel on 2017-03-31.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivityScope {
}
