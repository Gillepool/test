package com.example.daniel.article.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.article.R;
import com.example.daniel.article.mvp.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 2017-03-31.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Holder>{


    private LayoutInflater layoutInflater;
    private List<Article> articlesList = new ArrayList<>();

    public ArticleAdapter(LayoutInflater layoutInflater){
        this.layoutInflater = layoutInflater;
    }

    public void addArticles(List<Article> articles){
        this.articlesList.addAll(articles);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_item_article_lsit, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(articlesList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        @Inject protected Context context;
        @Bind(R.id.layout_item_article_list_thumbnail) protected ImageView articleThumb;
        @Bind(R.id.layout_item_article_list_title) protected TextView articleTitle;
        @Bind(R.id.layout_item_article_list_description) protected TextView articleDesc;
        @Bind(R.id.layout_item_article_list_date) protected TextView articleDate;

        public Holder(View itemItem){
            super(itemItem);
            ButterKnife.bind(this, itemItem);
        }

        public void bind(Article article) {
            articleTitle.setText(article.getTitle());
            articleDesc.setText(article.getDescription());
            articleTitle.setText(article.getDescription());
            articleTitle.setText(article.getTitle());
            Picasso.with(itemView.getContext()).load(article.getUrlToImage()).into(articleThumb);
        }
    }
}
