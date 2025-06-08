package com.richardlipa.cancionero.principal;

import com.richardlipa.cancionero.model.Cancion;
import com.richardlipa.cancionero.model.Cantante;
import com.richardlipa.cancionero.repository.ICancionRepository;
import com.richardlipa.cancionero.repository.ICantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component // 1. Marca la clase como componente de Spring
public class Principal {
    private final Scanner teclado;
    private final ICantanteRepository repositorio;
    private final ICancionRepository repositorioCancion;

    @Autowired // 2. Indica a Spring que debe inyectar las dependencias
    public Principal(ICantanteRepository repositorio,
                     ICancionRepository repositorioCancion) {
        this.teclado = new Scanner(System.in);
        this.repositorio = repositorio;
        this.repositorioCancion = repositorioCancion;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Ingresar Cantante en la BD Cancionario\s
                    2 - Ingresar Cancion de Cantante el la BD \s
                    3 - Buscar Cantante por Nombre \s
                    4 - Buscar Cancion Por Nombre   \s
             
                    0 - Salir
                   \s""";
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    ingresarCantante();
                    break;
                case 2:
                    IngresarNombreCancion();
                    break;
                case 3:
                    BuscarcantantePorNombre();
                    break;
                case 4:
                    BuscarCancionPorNombre();
                    break;


                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }



    public void  ingresarCantante() {
        Cantante cantante = new Cantante();

        System.out.println("ingresa Nombre Cantante");
        cantante.setNombres(teclado.nextLine());
        if (cantante.getNombres().trim().isEmpty()) {
            System.out.println("El título no puede estar vacío. Inténtalo de nuevo.");
            System.out.println("ingresa Nombre Cancion");
            cantante.setNombres(teclado.nextLine());
        }

        System.out.println("ingresa Pais de rigen de Cantante");
        cantante.setPais(teclado.nextLine());
        if (cantante.getPais().trim().isEmpty()) {
            System.out.println("El título no puede estar vacío. Inténtalo de nuevo.");
            System.out.println("ingresa Genero musical de la  Cancion");
            cantante.setPais(teclado.nextLine());
        }

        System.out.println("ingresa Edad De Cantante");
        cantante.setEdad(teclado.nextInt());
        teclado.nextLine();//limpia bufer
        repositorio.save(cantante);
        List<Cantante> listaNuevaCantantes = repositorio.findAll();
        listaNuevaCantantes.forEach(c->{
            System.out.println("idCantante: "+c.getId());
            System.out.println("Nombre: "+c.getNombres());
            System.out.println("Pais: "+c.getPais());
            System.out.println("edad: "+c.getEdad());
            System.out.println("-----------------------");
        });

    }
    private void IngresarNombreCancion(){

        List<Cantante> cantantes = repositorio.findAll();
        cantantes.forEach(c->{
            System.out.println("idCantante: "+c.getId());
            System.out.println("Nombre: "+c.getNombres());
            System.out.println("Pais: "+c.getPais());
            System.out.println("edad: "+c.getEdad());
          //  System.out.println("Canciones: "+c.getCanciones());
            if(c.getCanciones() != null && !c.getCanciones().isEmpty()) {
                System.out.println("Canciones:");
                c.getCanciones().forEach(cancion -> {
                    System.out.println("  - " + cancion.getTitulo() +
                            " (" + cancion.getDuracionEnMinutos() + " mins)");
                });
            }
            System.out.println("-----------------------");
        });

        Cancion cancion = new Cancion();

        System.out.println("ingresa Nombre Cancion");
        cancion.setTitulo(teclado.nextLine());
        if (cancion.getTitulo().trim().isEmpty()) {
            System.out.println("El título no puede estar vacío. Inténtalo de nuevo.");
            System.out.println("ingresa Nombre Cancion");
            cancion.setTitulo(teclado.nextLine());
        }

        System.out.println("ingresa genero de  Cancion");
        cancion.setGenero(teclado.nextLine());
        if (cancion.getGenero().trim().isEmpty()) {
            System.out.println("El título no puede estar vacío. Inténtalo de nuevo.");
            System.out.println("ingresa Genero musical de la  Cancion");
            cancion.setTitulo(teclado.nextLine());
        }

        System.out.println("ingresa duracion en minutos");
        cancion.setDuracionEnMinutos(teclado.nextInt());
        System.out.println("Ingresa id de Cantante");
        var idCantante = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        // Buscar cantante
        Cantante cantante = cantantes.stream()
                .filter(c -> c.getId() == idCantante)//busca cantante por id
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cantante no encontrado"));
        System.out.println("cantante "+ cantante);
        cancion.setCantante(cantante);
        // Guardar canción usando el repositorio de canciones
        repositorioCancion.save(cancion);
        // Actualizar relación bidireccional
        if(cantante.getCanciones() == null) {
            cantante.setCanciones(new ArrayList<>());
        }
        cantante.getCanciones().add(cancion);
        repositorio.save(cantante);

        // Listar todas las canciones usando el repositorio correcto
        System.out.println("\n=== LISTA ACTUALIZADA DE CANCIONES ===");
        repositorioCancion.findAll().forEach(c -> {
            System.out.println("ID: " + c.getId());
            System.out.println("Título: " + c.getTitulo());
            System.out.println("Género: " + c.getGenero());
            System.out.println("Duración: " + c.getDuracionEnMinutos() + " mins");
            System.out.println("Cantante: " + c.getCantante().getNombres());
            System.out.println("-----------------------");
        });


    }

    private void BuscarcantantePorNombre() {
        System.out.println("Ingresa el Nombre del Cantante que deseas buscar");
        String nombreCantante = teclado.nextLine();
        List<Cantante> cantaneEncontrado = repositorio.findByNombresContainingIgnoreCase(nombreCantante);
        System.out.println("----------------------- \n");
        cantaneEncontrado.forEach(c->{
            System.out.println("idCantante: "+c.getId());
            System.out.println("Nombre: "+c.getNombres());
            System.out.println("Pais: "+c.getPais());
            System.out.println("edad: "+c.getEdad());
            //  System.out.println("Canciones: "+c.getCanciones());
            if(c.getCanciones() != null && !c.getCanciones().isEmpty()) {
                System.out.println("Canciones:");
                c.getCanciones().forEach(cancion -> {
                    System.out.println("  - " + cancion.getTitulo() +
                            " (" + cancion.getDuracionEnMinutos() + " mins)"+
                            " Genero: "+cancion.getGenero());
                });
            }
            System.out.println("-----------------------");
        });
    }

    private  void    BuscarCancionPorNombre(){
        System.out.println("Ingresa titulo de tu cancion favorita para buscarla en la BD");
        String tituloCancion = teclado.nextLine();

       Optional<Cancion> cancionEncontrada = repositorioCancion.findByTituloContainingIgnoreCase(tituloCancion);
       if (cancionEncontrada.isPresent()){

           cancionEncontrada.map(c->{
               System.out.println(" ****************** \n");
               System.out.println("Titulo: "+ c.getTitulo());
               System.out.println("Genero: "+ c.getGenero());
               System.out.println("Duracion: "+ c.getDuracionEnMinutos());
               System.out.println("Cantante: "+ c.getCantante().getNombres());
               System.out.println("\n ****************** ");
               return null;
           });
       }else{
           System.out.println("No se enconro ninguna cancion con " + tituloCancion+ " Intenta nuevamente");

       }
    }


}
