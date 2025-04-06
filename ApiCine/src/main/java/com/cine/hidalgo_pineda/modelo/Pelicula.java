package com.cine.hidalgo_pineda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author victo
 */

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nombre;
    private Integer duracion;

}
