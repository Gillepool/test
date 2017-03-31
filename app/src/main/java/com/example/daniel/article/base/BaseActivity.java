package com.example.daniel.article.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.daniel.article.application.ArticleApplication;
import com.example.daniel.article.di.ApplicationComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Daniel on 2017-03-31.
 */

// Baseclass for all subactiviies
public abstract class BaseActivity extends AppCompatActivity{

    private ProgressDialog mProgressDialog;
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());
    }

    protected abstract int getContentView();

    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //To be used be child activites
        resolveDaggerDependency();
    }

    protected void resolveDaggerDependency(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void showDialog(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent(){
        return((ArticleApplication) getApplication()).getApplicationComponent();
    }
}
