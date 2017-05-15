package com.ulasalle.cobir;

import java.util.Arrays;

import net.semanticmetadata.lire.indexers.parallel.ParallelIndexer;

public class IndexadorParalelo {

	private ParallelIndexer indexador;
	private String rutaBD;
	private int numeroHilos;

	public IndexadorParalelo() {
		this.rutaBD = "index";
		this.numeroHilos = getNumeroHilos();
	}

	private int getNumeroHilos() {
		return Runtime.getRuntime().availableProcessors();
	}

	public void setRutaBD(String rutaBD) {
		this.rutaBD = rutaBD;
	}

	public void setNumeroHilos(int numeroHilos) {
		this.numeroHilos = numeroHilos;
	}

	public void indexar(String directorioImagenes, Opcion[] opciones) {
		this.indexador = new ParallelIndexer(this.numeroHilos, this.rutaBD, directorioImagenes);
		this.agregarCaracteristicas(opciones, Caracteristica.getInstancia());
		this.indexador.run();
	}

	private void agregarCaracteristicas(Opcion[] opciones, Caracteristica caracteristica) {
		Arrays.stream(opciones).forEach(opcion -> {
			indexador.addExtractor(caracteristica.getCaracteristica(opcion));
		});
	}

}