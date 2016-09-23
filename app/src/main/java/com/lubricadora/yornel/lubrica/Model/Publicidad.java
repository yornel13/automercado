package com.lubricadora.yornel.lubrica.Model;

import android.graphics.Bitmap;

/**
 * Created by Yornel on 21-sep-16.
 */
public class Publicidad {

    private String titulo;
    private String pie;
    private Bitmap imagen;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
