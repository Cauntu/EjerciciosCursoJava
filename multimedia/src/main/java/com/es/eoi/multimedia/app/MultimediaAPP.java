package com.es.eoi.multimedia.app;

import java.util.ArrayList;
import java.util.List;

import com.es.eoi.multimedia.entities.Pelicula;
import com.es.eoi.multimedia.entities.Serie;
import com.es.eoi.multimedia.interfaces.Reproducible;

public class MultimediaAPP {

	static List<Pelicula> misPeliculas;
	static List<Serie> misSeries;
	static List<Reproducible> miMedia;

	public static void main(String[] args) {

		miMedia = new ArrayList<Reproducible>();

		miMedia.add(new Pelicula("Titanic"));
		miMedia.add(new Pelicula("Interstellar"));
		miMedia.add(new Pelicula("Lluvia de albondigas"));

		miMedia.add(new Serie("GoT", 3));
		miMedia.add(new Serie("The Simpsons", 20000));
		miMedia.add(new Serie("Stranger Things", 30));

		for (Reproducible r : miMedia) {

			if (r instanceof Serie) {
				if ("GoT".compareTo( ((Serie)r).getNombre() ) == 0) {
					r.play();
					((Serie) r).previous();
					System.out.println(r);
					((Serie) r).next();
					System.out.println(r);
					((Serie) r).next();
					System.out.println(r);
					((Serie) r).next();
					System.out.println(r);
					
				}
			} else {
//				((Pelicula) r).play();
			}

//			System.out.println(r);
//			r.play();
//			System.out.println(r);
//			r.pause();
//			System.out.println(r);

		}
	}

}
