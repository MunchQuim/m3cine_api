package com.cine.hidalgo_pineda.controlador;

import com.cine.hidalgo_pineda.modelo.Pelicula;
import com.cine.hidalgo_pineda.servicio.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaServicio peliculaService;

    // Obtener todas las películas
    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.obtenerTodas();
    }

    // Obtener una película por ID
    @GetMapping("/{id}")
    public Optional<Pelicula> obtenerPelicula(@PathVariable Integer id) {
        return peliculaService.obtenerPorId(id);
    }

    // Agregar una nueva película
    @PostMapping
    public Pelicula agregarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    // Actualizar una película existente
    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
        return peliculaService.actualizar(id, pelicula);
    }

    // Eliminar una película por ID
    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Integer id) {
        peliculaService.eliminar(id);
    }
}
