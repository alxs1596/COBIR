/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulasalle.gui.utiles;

import com.ulasalle.obj.Imagen;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class AdministrarImagen {
    
    private ArrayList<Imagen> bibliotecaImagen;
    
    public AdministrarImagen() {
        bibliotecaImagen = new ArrayList<>();
    }
    
    public void guardarImagen(Imagen imagen) {
        bibliotecaImagen.add(imagen);
    }
    
    public void obtenerImagen(int codigo) {
        bibliotecaImagen.get(codigo);
    }
    
    public void eliminarImagen(int codigo) {
        bibliotecaImagen.remove(codigo);
    }
    
    public void eliminarTodo() {
        for(int i=0;i<bibliotecaImagen.size();i++) {
            bibliotecaImagen.remove(i);
        }
    }
    
    public int totalImagen() {
        return bibliotecaImagen.size();
    }
    
    
}
