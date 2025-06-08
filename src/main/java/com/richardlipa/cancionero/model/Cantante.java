package com.richardlipa.cancionero.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "cantantes")

public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombres;
    private String pais;
    private Integer edad;
    @OneToMany(mappedBy ="cantante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancion> canciones;

    public  List<Cancion> getCanciones(){
        return canciones;
    }

    public  Cantante(){

    }

    public Cantante(Long id, String nombres,String pais, Integer edad, List<Cancion> canciones) {
        this.id = id;
        this.nombres = nombres;
        this.pais = pais;
        this.edad = edad;
        this.canciones = canciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCanciones(List<Cancion> canciones) {
        canciones.forEach( c ->c.setCantante(this));
        this.canciones = canciones;
    }



    @Override
    public String toString() {
        return "Cantante{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +

                ", pais='" + pais + '\'' +
                ", edad=" + edad +
               // ", canciones=" + canciones +
                '}';
    }
}
