package com.richardlipa.cancionero.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String genero;
    private Integer duracionEnMinutos;
    @ManyToOne
    private Cantante cantante;

    public Cancion(){

    }

    public Cancion(long id, String titulo, String genero, Integer duracionEnMinutos, Cantante cantante) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracionEnMinutos = duracionEnMinutos;
        this.cantante = cantante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(Integer duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracionEnMinutos=" + duracionEnMinutos +
              //  ", cantante=" + cantante +
                '}';
    }
}
