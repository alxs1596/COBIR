import org.hamcrest.Matchers;
import org.junit.Test;

import com.ulasalle.cobir.Opcion;
import com.ulasalle.cobir.Buscador;
import com.ulasalle.cobir.Caracteristica;
import com.ulasalle.cobir.IndexadorParalelo;

import static org.junit.Assert.*;

import java.io.File;

/*
 *
 * @author Alexis
 */
public class COBIRTest {
	
	// Modificar Ruta de imagenes y de la bd generada
	String rutaImagenes = "C:\\Users\\alxs1\\Desktop\\Pruebas y Calidad de Software\\coil-100\\coil-100";
	String rutaBD = "C:\\Users\\alxs1\\Desktop\\Pruebas y Calidad de Software\\lucene-datos-cobir\\bd";
	
	public COBIRTest() {
		// una vez indexado cambiar a true
		boolean indexado = true;
		
		if (!indexado){
		
			// Indexacion
			
			IndexadorParalelo indexadorParalelo=new IndexadorParalelo();
	        indexadorParalelo.setRutaBD(rutaBD);
	        indexadorParalelo.indexar(rutaImagenes,new Opcion[]{Opcion.AutoColorCorrelogram});
		}
        
	}
	
    @Test 
    public void testTiempo() {
        
    	 Buscador buscador=new Buscador();
 		
    	 String rutaImagen = "C:\\Users\\alxs1\\Desktop\\Pruebas y Calidad de Software\\coil-100\\coil-100\\obj57__0.png";
         File imagen=new File(rutaImagen);
         
         String[] resultado = buscador
                 .buscar(
                         imagen,
                         rutaBD,
                         10,
                         Caracteristica.getInstancia().getCaracteristica( Opcion.AutoColorCorrelogram));
    	System.out.println(buscador.tiempoTranscurrido);
        assertThat(buscador.tiempoTranscurrido, Matchers.lessThan((long)1000));
    }
}
