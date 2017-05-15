package com.ulasalle.cobir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import net.semanticmetadata.lire.builders.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.GlobalFeature;
import net.semanticmetadata.lire.searchers.GenericFastImageSearcher;
import net.semanticmetadata.lire.searchers.ImageSearchHits;
import net.semanticmetadata.lire.searchers.ImageSearcher;

public class Buscador {
	public long tiempoTranscurrido = 0;

	public String[] buscar(File imagen, String rutaBD, int numeroResultados,
			Class<? extends GlobalFeature> caracteristica) {
		String[] imagenes = null;
		try {
			IndexReader lector = DirectoryReader.open(FSDirectory.open(Paths.get(rutaBD)));
			ImageSearcher buscadorImagenes = new GenericFastImageSearcher(numeroResultados, caracteristica);
			long start = System.currentTimeMillis();
			ImageSearchHits resultados = buscadorImagenes.search(ImageIO.read(imagen), lector);
			tiempoTranscurrido = System.currentTimeMillis() - start;
			imagenes = new String[resultados.length()];
			for (int i = 0; i < resultados.length(); i++) {
				imagenes[i] = lector.document(resultados.documentID(i))
						.getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagenes;
	}

}