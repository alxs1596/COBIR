package com.ulasalle.obj;

import javax.swing.Icon;

/**
 *
 * @author Christian
 */
public class Imagen {
    
    private int codigo;
    private Icon imagen;
    
    public Imagen(int codigo, Icon imagen) {
        this.codigo = codigo;
        this.imagen = imagen;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
