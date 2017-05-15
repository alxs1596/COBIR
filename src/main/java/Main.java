import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ulasalle.cobir.Buscador;
import com.ulasalle.cobir.Caracteristica;
import com.ulasalle.cobir.Opcion;

public class Main {

	public static void main(String[] args) {
		//IndexadorParalelo indexadorParalelo=new IndexadorParalelo();
        //indexadorParalelo.setRutaBD("C:\\Users\\alxs1\\Desktop\\Pruebas y Calidad de Software\\lucene-datos-cobir\\nombre_mi_bd");
        //indexadorParalelo.indexar("C:\\Users\\alxs1\\Desktop\\Pruebas y Calidad de Software\\coil-100\\coil-100",new Caracteristica.Opcion[]{Caracteristica.Opcion.AutoColorCorrelogram});

        Buscador buscador=new Buscador();
		
        File imagen=new File("C:\\Users\\Christian\\Downloads\\coil-100\\coil-100\\obj57__0.png");
        
        long start = System.currentTimeMillis();
        String[] resultado = buscador
                .buscar(
                        imagen,
                        "C:\\Users\\Christian\\Downloads\\coil-100\\coil-100\\db",
                        10,
                        Caracteristica.getInstancia().getCaracteristica( Opcion.AutoColorCorrelogram));
        long tiempo  =(System.currentTimeMillis() - start);
        System.out.println("Resultados obtenidos en " + buscador.tiempoTranscurrido + " milisegundos");
        
        JPanel jPanel = new JPanel(new GridLayout(1, resultado.length));
        Arrays.stream(resultado)
                .forEach(elemento->
                {
                	//System.out.println(elemento);
                	
                	BufferedImage imgRes =null;
                	try{
                		imgRes= ImageIO.read(new File(elemento));
                	}catch(Exception e){}
                    ImageIcon icon = new ImageIcon(imgRes);
                    Image image = icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon = new ImageIcon(newimg);
                    JLabel label = new JLabel(icon);
                    jPanel.add(label);
                });
        JOptionPane.showMessageDialog(null, jPanel);
	}

}
