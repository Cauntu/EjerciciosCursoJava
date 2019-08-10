package com.es.eoi.myWeirdoShop.services;

import java.util.List;

import com.es.eoi.myWeirdoShop.entities.Article;
import com.es.eoi.myWeirdoShop.entities.Article.Category;

public interface ArticleService {

	public boolean create(Article newArticle );

	public boolean update(Article newArticle);

	public Article read(String barCode);

	public List<Article> readAll(Category cat);

	public boolean delete(Article filter);
	
}
