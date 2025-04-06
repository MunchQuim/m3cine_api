/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import model.Session;
import java.util.ArrayList;
import model.Asiento;

/**
 *
 * @author joaquimpinsot
 */
public class SesionDiaria {
    private LocalDate dia;
    private Session sesion;
    private ArrayList<Asiento> asientosNormales;
    private ArrayList<Asiento> asientosAdaptados;
    private ArrayList<Asiento> asientosVip;

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Session getSesion() {
        return this.sesion;
    }

    public void setSesion(Session sesion) {
        this.sesion = sesion;
    }

    public ArrayList<Asiento> getAsientosNormales() {
        return this.asientosNormales;
    }

    public void setAsientosNormales(ArrayList<Asiento> asientosNormales) {
        this.asientosNormales = asientosNormales;
    }

    public ArrayList<Asiento> getAsientosAdaptados() {
        return this.asientosAdaptados;
    }

    public void setAsientosAdaptados(ArrayList<Asiento> asientosAdaptados) {
        this.asientosAdaptados = asientosAdaptados;
    }

    public ArrayList<Asiento> getAsientosVip() {
        return this.asientosVip;
    }

    public void setAsientosVip(ArrayList<Asiento> asientosVip) {
        this.asientosVip = asientosVip;
    }

    public SesionDiaria(LocalDate dia, Session sesion, ArrayList<Asiento> asientosNormales, ArrayList<Asiento> asientosVip,ArrayList<Asiento> asientosAdaptados) {
        this.dia = dia;
        this.sesion = sesion;
        this.asientosNormales = asientosNormales;
        this.asientosAdaptados = asientosAdaptados;
        this.asientosVip = asientosVip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SesionDiaria{");
        sb.append("dia=").append(dia);
        sb.append(", sesion=").append(sesion);
        sb.append(", asientosNormales=").append(asientosNormales);
        sb.append(", asientosAdaptados=").append(asientosAdaptados);
        sb.append(", asientosVip=").append(asientosVip);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
