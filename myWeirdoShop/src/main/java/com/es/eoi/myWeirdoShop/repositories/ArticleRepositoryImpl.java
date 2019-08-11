package com.es.eoi.myWeirdoShop.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.es.eoi.myWeirdoShop.entities.Article;
import com.es.eoi.myWeirdoShop.entities.Article.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArticleRepositoryImpl implements ArticleRepository {

	private static final String DB_PATH = "src/main/resources/articleDB.json";

	private List<Article> dataBase = new ArrayList<Article>();
	private List<Article> dump = new ArrayList<Article>();
	
	public boolean create(Article newArticle) {

		if (newArticle != null) {

			if (readJSON()) {
				
				for(Article a : dump) {
					this.dataBase.add(a);
				}
				
				this.dataBase.add(newArticle);
				//this.dataBase.sort(null);

				if (writeJSON()) {
					return true;
				}

			}

		}

		return false;
	}

	public boolean update(Article newArticle) {

		if (newArticle != null) {

			for (Article a : dataBase) {

				if (newArticle.getBarCode().equals(a.getBarCode())) {

				}
			}

		}

		return false;
	}

	public Article read(String barCode) {

		if (barCode != null) {

			for (Article a : dataBase) {
				if (barCode.equals(a.getBarCode())) {
					return a;
				}
			}

		}

		return null;
	}

	public List<Article> readAll(Category cat) {

		List<Article> selectedArticles = new ArrayList<Article>();

		if (cat != null) {

			for (Article a : dataBase) {
				// TODO
				if (cat.equals(a.getCat())) {
					selectedArticles.add(a);
				}

			}

		}

		return null;
	}

	public boolean delete(Article filter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean readJSON() {

		try {
			File f = new File(DB_PATH);
			BufferedReader dBReader = new BufferedReader(new FileReader(f.getAbsolutePath()));

			Gson gson = new Gson();
			Article[] articlesFromDB = gson.fromJson(dBReader, Article[].class);

			if(articlesFromDB != null) {
				this.dump = Arrays.asList(articlesFromDB);
			}

			return true;

		} catch (FileNotFoundException e) {
			return false;
		}
	}

	public boolean writeJSON() {

		try {
			File f = new File(DB_PATH);
			FileWriter fw = new FileWriter(f.getAbsolutePath());

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Article[] articlesToDB = dataBase.toArray(new Article[0]);
			String json = gson.toJson(articlesToDB);
			fw.write(json);
			fw.close();

			return true;

		} catch (IOException e) {
			return false;
		}

	}

}
