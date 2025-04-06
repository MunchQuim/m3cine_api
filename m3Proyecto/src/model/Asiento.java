/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.TipoAsientosEnum;
import model.Room;

/**
 *
 * @author joaquimpinsot
 */
public final class Asiento {

    private TipoAsientosEnum tipoAsiento;
    private int index;
    private boolean estaOcupado;
    private double precio;
    private Room sala;

    public TipoAsientosEnum getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsientosEnum tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Room getSala() {
        return sala;
    }

    public void setSala(Room sala) {
        this.sala = sala;
    }

    public Asiento(TipoAsientosEnum tipoAsiento, int index, boolean estaOcupado, Room sala) {
        this.tipoAsiento = tipoAsiento;
        this.index = index;
        this.estaOcupado = estaOcupado;
        this.sala = sala;
        asignarPrecio();
    }

    public void asignarPrecio() {
        switch (this.tipoAsiento) {
            case Adaptado:
                this.precio = 5;
                break;
            case Normal:
                this.precio = 10;
                break;
            case Vip:
                this.precio = 15;
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asiento{");
        sb.append("tipoAsiento=").append(tipoAsiento);
        sb.append(", index=").append(index);
        sb.append(", estaOcupado=").append(estaOcupado);
        sb.append(", precio=").append(precio);
        sb.append(", sala=").append(sala);
        sb.append('}');
        return sb.toString();
    }

    public String getTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("\nsala : ").append(this.sala.getNumSala());
        ticket.append("\ntipo : ").append(this.tipoAsiento);
        ticket.append("\nnumero : ").append(this.index);
        ticket.append("\nprecio : ").append(this.precio);
        ticket.append("\n-------------------").append(this.precio);
        return ticket.toString();
    }

}
