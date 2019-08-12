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
		return this.repo.create(newArticle);
	}

	@Override
	public boolean update(Article newArticle) {
		return this.repo.update(newArticle);
	}

	@Override
	public Article read(String barCode) {
		return this.repo.read(barCode);
	}
	
	@Override
	public List<Article> readAll() {
		return this.repo.readAll();
	}
	
	
	@Override
	public List<Article> readAll(Category cat) {
		return this.repo.readAll(cat);
	}

	@Override
	public boolean delete(String barCode) {
		return this.repo.delete(barCode);
	}

}
