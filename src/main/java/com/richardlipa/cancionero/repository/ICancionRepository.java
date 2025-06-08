package com.richardlipa.cancionero.repository;

import com.richardlipa.cancionero.model.Cancion;
import com.richardlipa.cancionero.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICancionRepository extends JpaRepository<Cancion, Long> {
   Optional<Cancion> findByTituloContainingIgnoreCase(String tituloCancion);
}
