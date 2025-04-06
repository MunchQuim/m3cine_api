package com.cine.hidalgo_pineda.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cine.hidalgo_pineda.modelo.Pelicula;
import com.cine.hidalgo_pineda.repositorio.PeliculaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServicio {
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    // Obtener todas las películas
    public List<Pelicula> obtenerTodas() {
        return peliculaRepositorio.findAll();
    }

    // Obtener una película por ID
    public Optional<Pelicula> obtenerPorId(Integer id) {
        return peliculaRepositorio.findById(id);
    }

    // Guardar una nueva película
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepositorio.save(pelicula);
    }

    // Actualizar una película existente
    public Pelicula actualizar(Integer id, Pelicula nuevaPelicula) {
        return peliculaRepositorio.findById(id)
                .map(p -> {
                    p.setNombre(nuevaPelicula.getNombre());
                    p.setDuracion(nuevaPelicula.getDuracion());
                    return peliculaRepositorio.save(p);
                })
                .orElse(null);
    }

    // Eliminar una película por ID
    public void eliminar(Integer id) {
        peliculaRepositorio.deleteById(id);
    }


}
