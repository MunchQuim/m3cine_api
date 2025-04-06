/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaquimpinsot
 */
public class Film {
    private String nombre;
    private int duracion;

    public Film(String title, int duration) {
        this.nombre = title;
        this.duracion = duration;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Film{" + "title=" + nombre + ", duration=" + duracion + '}';
    }
    
}
