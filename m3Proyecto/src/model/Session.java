/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Film;
import model.Room;
import java.time.LocalTime;
/**
 *
 * @author joaquimpinsot
 */
public final class Session {
    private Film pelicula;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private Room sala;

    public Film getPelicula() {
        return pelicula;
    }

    public void setPelicula(Film pelicula) {
        this.pelicula = pelicula;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Room getSala() {
        return sala;
    }

    public void setSala(Room sala) {
        this.sala = sala;
    }

    public Session(Film pelicula, LocalTime horaInicio, Room sala) {
        this.pelicula = pelicula;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.horaFinal = calcularHoraFinal();        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Session{");
        sb.append("pelicula=").append(pelicula);
        sb.append(", horaInicio=").append(horaInicio);
        sb.append(", horaFinal=").append(horaFinal);
        sb.append(", sala=").append(sala);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    public LocalTime calcularHoraFinal(){
        return this.horaInicio.plusMinutes(this.pelicula.getDuracion()+10);
    }
    
    
}
