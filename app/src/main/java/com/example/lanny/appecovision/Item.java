package com.example.lanny.appecovision;

/**
 * Created by horse on 03/07/16.
 */
public class Item {

    public static int[] IMAGENES = {R.drawable.i122 , R.drawable.i8 , R.drawable.i35, R.drawable.i29, R.drawable.i57, R.drawable.i5, R.drawable.i3, R.drawable.i15, R.drawable.i74azul,
            R.drawable.i5azul, R.drawable.i2 };

    //R.drawable.i8, R.drawable.i35, R.drawable.i29otro, R.drawable.i57, R.drawable.i5, R.drawable.i3, R.drawable.i15, R.drawable.i74azul,
    //R.drawable.i5azul, R.drawable.i2

    public static String[] OPCIONES = {"12c,Ninguno,10", "Ninguno,8c,X", "X,35c,Ninguno", "Ninguno,29c,X", "57c,Ninguno,X", "X,5c,Ninguno", "3c,Ninguno,X", "Ninguno,15c,X", "X,Ninguno,74c", "5c,Ninguno,X", "Ninguno,2c,X"};

    public static int numeroItems = 0;

    private int imagen = 0;

    private String[]  opciones;

    public Item(){
        setImagen(IMAGENES[numeroItems]);
        setOpciones(OPCIONES[numeroItems].split(","));
        numeroItems++;

    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
