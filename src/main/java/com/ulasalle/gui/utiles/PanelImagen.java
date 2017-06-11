/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulasalle.gui.utiles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Christian
 */
public class PanelImagen extends  JPanel{
    public PanelImagen() {
            setLayout(new GridLayout(0, 2, 5, 5));
            JPanel panel = new JPanel();
            JScrollPane scroller = new JScrollPane(panel);
            File[] files = new File("D:\\db\\").listFiles(new java.io.FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName().toLowerCase();
                    return pathname.isFile() &&
                            name.endsWith(".png") ||
                            name.endsWith(".jpg");
                }
            });
            Arrays.sort(files);
            int count = 0;
            while (count < 10 && count < files.length) {
                try {
                    System.out.println(count + "; " + files[count]);
                    add(new JLabel(new ImageIcon(ImageIO.read(files[count]))));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                count++;
            }
        }
}
