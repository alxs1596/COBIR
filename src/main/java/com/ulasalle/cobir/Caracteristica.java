package com.ulasalle.cobir;

import java.util.HashMap;
import java.util.Map;

import net.semanticmetadata.lire.imageanalysis.features.GlobalFeature;
import net.semanticmetadata.lire.imageanalysis.features.global.AutoColorCorrelogram;
import net.semanticmetadata.lire.imageanalysis.features.global.BinaryPatternsPyramid;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.imageanalysis.features.global.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.features.global.EdgeHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.FCTH;
import net.semanticmetadata.lire.imageanalysis.features.global.FuzzyColorHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.FuzzyOpponentHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.Gabor;
import net.semanticmetadata.lire.imageanalysis.features.global.JCD;
import net.semanticmetadata.lire.imageanalysis.features.global.JpegCoefficientHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.LocalBinaryPatterns;
import net.semanticmetadata.lire.imageanalysis.features.global.LuminanceLayout;
import net.semanticmetadata.lire.imageanalysis.features.global.OpponentHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.PHOG;
import net.semanticmetadata.lire.imageanalysis.features.global.ScalableColor;
import net.semanticmetadata.lire.imageanalysis.features.global.SimpleColorHistogram;
import net.semanticmetadata.lire.imageanalysis.features.global.Tamura;
import net.semanticmetadata.lire.imageanalysis.features.global.joint.JointHistogram;

public class Caracteristica {

	private Map<Opcion, Class<? extends GlobalFeature>> caracteristicas;

	private static class LazyHolder {
		private static final Caracteristica INSTANCIA = new Caracteristica();
	}

	private Caracteristica() {
		cargarCaracteristicas();
	}

	public static Caracteristica getInstancia() {
		return LazyHolder.INSTANCIA;
	}

	private void cargarCaracteristicas() {
		this.caracteristicas = new HashMap<>();
		this.caracteristicas.put(Opcion.CEDD, CEDD.class);
		this.caracteristicas.put(Opcion.FCTH, FCTH.class);
		this.caracteristicas.put(Opcion.AutoColorCorrelogram, AutoColorCorrelogram.class);
		this.caracteristicas.put(Opcion.ColorLayout, ColorLayout.class);
		this.caracteristicas.put(Opcion.JCD, JCD.class);
		this.caracteristicas.put(Opcion.ScalableColor, ScalableColor.class);
		this.caracteristicas.put(Opcion.EdgeHistogram, EdgeHistogram.class);
		this.caracteristicas.put(Opcion.Tamura, Tamura.class);
		this.caracteristicas.put(Opcion.Gabor, Gabor.class);
		this.caracteristicas.put(Opcion.SimpleColorHistogram, SimpleColorHistogram.class);
		this.caracteristicas.put(Opcion.OpponentHistogram, OpponentHistogram.class);
		this.caracteristicas.put(Opcion.JointHistogram, JointHistogram.class);
		this.caracteristicas.put(Opcion.LuminanceLayout, LuminanceLayout.class);
		this.caracteristicas.put(Opcion.PHOG, PHOG.class);
		this.caracteristicas.put(Opcion.BinaryPatternsPyramid, BinaryPatternsPyramid.class);
		this.caracteristicas.put(Opcion.FuzzyColorHistogram, FuzzyColorHistogram.class);
		this.caracteristicas.put(Opcion.FuzzyOpponentHistogram, FuzzyOpponentHistogram.class);
		this.caracteristicas.put(Opcion.JpegCoefficientHistogram, JpegCoefficientHistogram.class);
		this.caracteristicas.put(Opcion.LocalBinaryPatterns, LocalBinaryPatterns.class);
		/*
		 * local caracteristicas
		 * clasesExtractores.put("CvSurfExtractor",CvSurfExtractor.class);
		 * clasesExtractores.put("CvSiftExtractor",CvSiftExtractor.class);
		 * clasesExtractores.put("SelfSimilaritiesExtractor",
		 * SelfSimilaritiesExtractor.class);
		 * clasesExtractores.put("SelfSimilaritiesOrigExtractor",
		 * SelfSimilaritiesOrigExtractor.class);
		 * clasesExtractores.put("ShapeContextExtractor",ShapeContextExtractor.
		 * class); clasesExtractores.put("SiftExtractor",SiftExtractor.class);
		 * clasesExtractores.put("SurfExtractor",SurfExtractor.class);
		 */
	}

	public Class<? extends GlobalFeature> getCaracteristica(Opcion opcion) {
		return this.caracteristicas.get(opcion);
	}

}