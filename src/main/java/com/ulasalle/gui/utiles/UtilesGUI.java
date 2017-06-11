package com.ulasalle.gui.utiles;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Christian
 */
public class UtilesGUI{

    public void abrirRutas(JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Tipo Imagenes", ImageIO.getReaderFileSuffixes());

        fileChooser.setFileFilter(imageFilter);
        //int rVal = c.showOpenDialog(panel);
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(archivo)).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
                label.setIcon(imageIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void guardarImagenes() {
        
    }

}
