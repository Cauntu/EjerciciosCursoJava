package com.es.eoi.myWeirdoShop.services;

import java.util.List;

import com.es.eoi.myWeirdoShop.entities.Article;
import com.es.eoi.myWeirdoShop.entities.Article.Category;
import com.es.eoi.myWeirdoShop.repositories.ArticleRepository;
import com.es.eoi.myWeirdoShop.repositories.ArticleRepositoryImpl;

public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository repo;

	public ArticleServiceImpl() {
		this.repo = new ArticleRepositoryImpl();
	}

	@Override
	public boolean create(Article newArticle) {
		this.repo.create(newArticle);
		return false;
	}

	@Override
	public boolean update(Article newArticle) {
		this.repo.update(newArticle);
		return false;
	}

	@Override
	public Article read(String barCode) {
		this.repo.read(barCode);
		return null;
	}

	@Override
	public List<Article> readAll(Category cat) {
		this.readAll(cat);
		return null;
	}

	@Override
	public boolean delete(Article filter) {
		this.repo.delete(filter);
		return false;
	}

}
