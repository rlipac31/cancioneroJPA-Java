package com.richardlipa.cancionero.repository;

import com.richardlipa.cancionero.model.Cancion;
import com.richardlipa.cancionero.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICantanteRepository extends JpaRepository<Cantante, Long> {
    // Búsqueda que ignora mayúsculas/minúsculas y encuentra coincidencias parciales
    List<Cantante> findByNombresContainingIgnoreCase(String nombre);
}
