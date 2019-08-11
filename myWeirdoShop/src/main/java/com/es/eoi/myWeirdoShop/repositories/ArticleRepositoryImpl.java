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
	private List<Article> dump;

	public boolean create(Article newArticle) {
		
		Integer lastBarCode;
		String barCode;
		
		if (newArticle != null) {

			if (readJSON()) {
				
				if(dataBase.size() >= 1) {
					
					lastBarCode = Integer.parseInt(dataBase.get(dataBase.size() -1).getBarCode() );
				} else {
					lastBarCode = Integer.parseInt("0000");
				}
				
				lastBarCode++;
				
				switch (lastBarCode.toString().length()) {
				
				case 1:
					barCode = "000".concat(lastBarCode.toString());
					break;
					
				case 2:
					barCode = "00".concat(lastBarCode.toString());
					break;
					
				case 3:
					barCode = "0".concat(lastBarCode.toString());
					break;
					
				case 4:
					barCode = lastBarCode.toString();
					break;

				default:
					System.out.println("Error BarCode");
					return false;
				}
				
				newArticle.setBarCode(barCode);
				
				this.dataBase.add(newArticle);
				// this.dataBase.sort(null);

				if (writeJSON()) {
					return true;
				}

			}

		}

		return false;
	}

	public boolean update(Article newArticle) {

		if (newArticle != null) {

			if (readJSON()) {

				for (Article a : dataBase) {

					if (newArticle.getBarCode().equals(a.getBarCode())) {
						dataBase.set(dataBase.indexOf(a), newArticle);
					}
				}

				if (writeJSON()) {
					return true;
				}

			}

		}

		return false;
	}

	public Article read(String barCode) {

		if (barCode != null) {

			if (readJSON()) {

				for (Article a : dataBase) {
					if (barCode.equals(a.getBarCode())) {
						return a;
					}
				}

			}

		}

		return null;
	}

	public List<Article> readAll() {

		List<Article> selectedArticles = new ArrayList<Article>();

		if (readJSON()) {

			for (Article a : dataBase) {

				selectedArticles.add(a);

			}
		}

		return null;
	}

	public List<Article> readAll(Category cat) {

		List<Article> selectedArticles = new ArrayList<Article>();

		if (cat != null) {

			if (readJSON()) {

				for (Article a : dataBase) {
					if (cat.equals(a.getCat())) {
						selectedArticles.add(a);
					}

				}
			}

		}

		return null;
	}

	public boolean delete(String barCode) {

		if (barCode != null) {

			if (readJSON()) {

				for (Article a : dataBase) {
					if (barCode.equals(a.getBarCode())) {
						dataBase.remove(a);
					}
				}
				
				if(writeJSON()) {
					return true;
				}
				

			}

		}
		
		return false;
	}

	public boolean readJSON() {

		dump = new ArrayList<Article>();

		try {
			File f = new File(DB_PATH);
			BufferedReader dBReader = new BufferedReader(new FileReader(f.getAbsolutePath()));

			Gson gson = new Gson();
			Article[] articlesFromDB = gson.fromJson(dBReader, Article[].class);

			if (articlesFromDB != null) {
				this.dump = Arrays.asList(articlesFromDB);

				for (Article a : dump) {
					this.dataBase.add(a);
				}
			}

			return true;

		} catch (Exception e) {
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

		} catch (Exception e) {
			return false;
		}

	}

}
