package com.cine.hidalgo_pineda.repositorio;

import com.cine.hidalgo_pineda.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {

}
