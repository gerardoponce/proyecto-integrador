package com.example.food.model;

public class Postre {

    private String uid;
    private String Imagen;
    private String Nombre;
    private String precio;
    private String Tiempo;

    public Postre(String imagen, String nombre, String precio, String tiempo) {
        Imagen = imagen;
        Nombre = nombre;
        this.precio = precio;
        Tiempo = tiempo;
    }

    public Postre() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String tiempo) {
        Tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + '\'' +
                ", Precio: " + precio + '\'' +
                ", Tiempo estimado: " + Tiempo + '\'';
    }
}
