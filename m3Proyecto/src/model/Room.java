/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaquimpinsot
 */
public class Room {

    private String numSala;
    private int numAsientos;
    private int numAsientosVip;
    private int numAsientosAdaptados;

    public Room(String numSala, int asientos, int asientosVip, int asientosAdaptados) {
        this.numSala = numSala;
        this.numAsientos = asientos;
        this.numAsientosVip = asientosVip;
        this.numAsientosAdaptados = asientosAdaptados;
    }

    public int getNumAsientosAdaptados() {
        return numAsientosAdaptados;
    }

    public void setNumAsientosAdaptados(int numAsientosAdaptados) {
        this.numAsientosAdaptados = numAsientosAdaptados;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getNumAsientosVip() {
        return numAsientosVip;
    }

    public void setNumAsientosVip(int numAsientosVip) {
        this.numAsientosVip = numAsientosVip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room{");
        sb.append("numSala=").append(numSala);
        sb.append(", numAsientos=").append(numAsientos);
        sb.append(", numAsientosVip=").append(numAsientosVip);
        sb.append(", numAsientosAdaptados=").append(numAsientosAdaptados);
        sb.append('}');
        return sb.toString();
    }


 

   
}
