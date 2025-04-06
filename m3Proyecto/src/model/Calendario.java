/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author joaquimpinsot
 */
public class Calendario {
    private ArrayList<SesionDiaria> sesionesDiarias;

    public ArrayList<SesionDiaria> getSesionesDiarias() {
        return sesionesDiarias;
    }

    public void setSesionesDiarias(ArrayList<SesionDiaria> sesionesDiarias) {
        this.sesionesDiarias = sesionesDiarias;
    }

    public Calendario(ArrayList<SesionDiaria> sesionesDiarias) {
        this.sesionesDiarias = sesionesDiarias;
    }

    public Calendario() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Calendario{");
        sb.append("sesionesDiarias=").append(sesionesDiarias);
        sb.append('}');
        return sb.toString();
    }
    
}
